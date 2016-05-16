with Measures; use Measures;
with Emergency;

-- This Package contains a storage container for Users as
-- well as the neccessary functions/procedures for manipulating them.
package body AccountManagementSystem is

-- A type declaration that stores the permission for three different
-- types of users
   type Permissions is record
      Friend : Boolean := False;
      Emergency : Boolean := False;
      Insurer : Boolean := False;
   end record;

-- A type declaration to store all the information for a user.
   type User is record
      active : Boolean := False;
      location : GPSLocation;
      steps : Footsteps := 0;
      vitals : BPM := -1;
      friend : UserID := -1;
      insurer : UserID := -1;
      VitalsPermissions: Permissions;
      LocationPermissions : Permissions;
      FootstepsPermissions : Permissions;
   end record;

-- A type definition to create a storage array of users
   type UserStorage is array(UserID) of User;


-- Declaration of packages static variables.
   NumUsers : UserID;
   EmergencyServices : UserID;
   Users : UserStorage;


-- procedure that should be run at creation of the package instance.
-- creates the emergency service user for the system.
   procedure Init is
   begin
      NumUsers := -1;
      EmergencyServices := CreateUser;
   end Init;


-- Increment the user count, set the next user as being active and 
-- return the new UserID
   function CreateUser return UserID is
   begin
      NumUsers := NumUsers + 1;
      Users(NumUsers).active := True;
      return NumUsers;
   end CreateUser;
	   

-- Set the Wearer's insurer to Insurer;   
   procedure SetInsurer(Wearer : in UserID; Insurer : in UserID) is
   begin
      Users(Wearer).insurer := Insurer;
   end SetInsurer;


-- Set the Wearer's insurer to default UserID  
   procedure RemoveInsurer(Wearer : in UserID) is
   begin
      Users(Wearer).insurer := -1;
   end RemoveInsurer;
   

-- Return UserID of Wearer's Insurer.
   function ReadInsurer(Wearer : in UserID) return UserID is
   begin
      return Users(Wearer).insurer;
   end ReadInsurer;

   
-- Set Wearer's friend to NewFriend.
   procedure SetFriend(Wearer : in UserID; NewFriend : in UserID) is
   begin
      Users(Wearer).friend := NewFriend;
   end SetFriend;

   
-- Return UserID of Wearer's friend.
   function ReadFriend(Wearer : in UserID) return UserID is
   begin
      return Users(Wearer).friend;
   end ReadFriend;

   
-- Set Wearer's friend to default UserID
   procedure RemoveFriend(Wearer : in UserID) is
   begin
      Users(Wearer).friend := -1;
   end RemoveFriend;

    
-- Set the Wearer's Vitals permissions for the Other user to that stored in 
-- Allow. The procedure must determine if Other is the Wearer's friend, 
-- insurer or the emergency services
   procedure UpdateVitalsPermissions(Wearer : in UserID;
				     Other : in UserID;
				     Allow : in Boolean) is 
   begin
      if Other = EmergencyServices then
         Users(Wearer).VitalsPermissions.Emergency := Allow;
      elsif Other = Users(Wearer).insurer then
         Users(Wearer).VitalsPermissions.Insurer := Allow;
      elsif Other = Users(Wearer).friend then
         Users(Wearer).VitalsPermissions.Friend := Allow;
      end if;
   end UpdateVitalsPermissions;

   
-- Set the Wearer's Footsteps permissions for the Other user to that stored in 
-- Allow. The procedure must determine if Other is the Wearer's friend, 
-- insurer or the emergency services
   procedure UpdateFootstepsPermissions(Wearer : in UserID;
					Other : in UserID;
					Allow : in Boolean) is
   begin
      if Other = EmergencyServices then
         Users(Wearer).FootstepsPermissions.Emergency := Allow;
      elsif Other = Users(Wearer).insurer then
         Users(Wearer).FootstepsPermissions.Insurer := Allow;
      elsif Other = Users(Wearer).friend then
         Users(Wearer).FootstepsPermissions.Friend := Allow;
      end if;
   end UpdateFootstepsPermissions;

   
-- Set the Wearer's Location permissions for the Other user to that stored in 
-- Allow. The procedure must determine if Other is the Wearer's friend, 
-- insurer or the emergency services
   procedure UpdateLocationPermissions(Wearer : in UserID;
				       Other : in UserID;
				       Allow : in Boolean) is 
   begin
      if Other = EmergencyServices then
         Users(Wearer).LocationPermissions.Emergency := Allow;
      elsif Other = Users(Wearer).insurer then
         Users(Wearer).LocationPermissions.Insurer := Allow;
      elsif Other = Users(Wearer).friend then
         Users(Wearer).LocationPermissions.Friend := Allow;
      end if;
   end UpdateLocationPermissions;
 

-- Set the Wearer's vitals to NewVitals.
   procedure UpdateVitals(Wearer : in UserID; NewVitals : in BPM) is 
   begin
      Users(Wearer).vitals := NewVitals;
   end UpdateVitals;
  

-- Set the Wearer's steps to NewFootsteps.
   procedure UpdateFootsteps(Wearer : in UserID; NewFootsteps : in Footsteps) is
   begin
      Users(Wearer).steps := NewFootsteps;
   end UpdateFootsteps;
   

-- Set the Wearer's location to NewLocation.
   procedure UpdateLocation(Wearer : in UserID; NewLocation : in GPSLocation) is
   begin
      Users(Wearer).location := NewLocation;
   end UpdateLocation;
   

-- Check that the Requestor has permission to read the TargetUser's vitals,
-- if yes, return the TargetUser's vitals else return -1.
   function ReadVitals(Requester : in UserID; TargetUser : in UserID)
		      return BPM is
   PermissionGranted : Boolean;
   begin
      PermissionGranted := False;

      if Requester = EmergencyServices and 
         Users(TargetUser).VitalsPermissions.Emergency then
            PermissionGranted := True;
      end if;

      if Requester = Users(TargetUser).insurer and 
         Users(TargetUser).VitalsPermissions.Insurer then
            PermissionGranted := True;
      end if;

      if Requester = Users(TargetUser).friend and 
         Users(TargetUser).VitalsPermissions.Friend then
            PermissionGranted := True;
      end if;

      if Requester = TargetUser then
         PermissionGranted := True;
      end if;

      if PermissionGranted = True then
         return Users(TargetUser).vitals;
      else
         return -1;
      end if;
   end ReadVitals;
   

-- Check that the Requestor has permission to read the TargetUser's vitals,
-- if yes, return the TargetUser's vitals else return -1.
   function ReadFootsteps(Requester : in UserID; TargetUser : in UserID)
			 return Footsteps is 
   PermissionGranted : Boolean;
   begin
      PermissionGranted := False;

      if Requester = EmergencyServices and 
         Users(TargetUser).FootstepsPermissions.Emergency then
            PermissionGranted := True;
      end if;

      if Requester = Users(TargetUser).insurer and 
         Users(TargetUser).FootstepsPermissions.Insurer then
            PermissionGranted := True;
      end if;

      if Requester = Users(TargetUser).friend and 
         Users(TargetUser).FootstepsPermissions.Friend then
            PermissionGranted := True;
      end if;

      if Requester = TargetUser then
         PermissionGranted := True;
      end if;

      if PermissionGranted = True then
         return Users(TargetUser).steps;
      else
         return 0;
      end if;
   end ReadFootsteps;
   

-- Check that the Requestor has permission to read the TargetUser's location,
-- if yes, return the TargetUser's location else return default location.
   function ReadLocation(Requester : in UserID; TargetUser : in UserID)
			return GPSLocation is
   PermissionGranted : Boolean;
   defaultLocation : GPSLocation;
   begin
      
      defaultLocation.Long := 0.0;
      defaultLocation.Lat := 0.0;
      PermissionGranted := False;

      if Requester = EmergencyServices and 
         Users(TargetUser).LocationPermissions.Emergency then
            PermissionGranted := True;
      end if;

      if Requester = Users(TargetUser).insurer and 
         Users(TargetUser).LocationPermissions.Insurer then
            PermissionGranted := True;
      end if;

      if Requester = Users(TargetUser).friend and 
         Users(TargetUser).LocationPermissions.Friend then
            PermissionGranted := True;
      end if;

      if Requester = TargetUser then
         PermissionGranted := True;
      end if;

      if PermissionGranted = True then
         return Users(TargetUser).location;
      else
         return defaultLocation;
      end if;
   end ReadLocation;
   
-- Update the Wearer's Location and Vitals, then check if the Emergency 
-- Services has permission to see the Wearer's vitals.
-- If yes, call ContactEmergency.
   procedure ContactEmergency(Wearer : in UserID; 
			      Location : in GPSLocation; 
			      Vitals : in BPM) is
   begin
      UpdateVitals(Wearer, Vitals);
      UpdateLocation(Wearer, Location);
      if Users(Wearer).VitalsPermissions.Emergency = True then
         Emergency.ContactEmergency(Wearer, Vitals, Location);
      end if;
   end ContactEmergency;
   
end AccountManagementSystem;
