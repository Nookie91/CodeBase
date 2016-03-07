with Measures; use Measures;
with Emergency;

package body AccountManagementSystem is
   
   procedure Init is
   begin
   end Init;
   
   function CreateUser return UserID is
   begin
   end CreateUser;
	 
   
   procedure SetInsurer(Wearer : in UserID; Insurer : in UserID) is
   begin
   end SetInsurer;
   
   procedure RemoveInsurer(Wearer : in UserID) is
   begin
   end RemoveInsurer;
   
   function ReadInsurer(Wearer : in UserID) return UserID is
   begin
   end ReadInsurer;
   
   procedure SetFriend(Wearer : in UserID; NewFriend : in UserID) is
   begin
   end SetFriend;
   
   function ReadFriend(Wearer : in UserID) return UserID is
   begin
   end ReadFriend;
   
   procedure RemoveFriend(Wearer : in UserID) is
   begin
   end RemoveFriend;
     
   procedure UpdateVitalsPermissions(Wearer : in UserID;
				     Other : in UserID;
				     Allow : in Boolean) is 
   begin
   end UpdateVitalsPermissions;
   
   procedure UpdateFootstepsPermissions(Wearer : in UserID;
					Other : in UserID;
					Allow : in Boolean) is
   begin
   end UpdateFootstepsPermissions;
   
   procedure UpdateLocationPermissions(Wearer : in UserID;
				       Other : in UserID;
				       Allow : in Boolean) is 
   begin
   end UpdateLocationPermissions;
   
   procedure UpdateVitals(Wearer : in UserID; NewVitals : in BPM) is 
   begin
   end UpdateVitals;
   
   procedure UpdateFootsteps(Wearer : in UserID; NewFootsteps : in Footsteps) is
   begin
   end UpdateFootsteps;
   
   procedure UpdateLocation(Wearer : in UserID; NewLocation : in GPSLocation) is
   begin
   end UpdateLocation;
   
   function ReadVitals(Requester : in UserID; TargetUser : in UserID)
		      return BPM is
   begin
   end ReadVitals;
   
   function ReadFootsteps(Requester : in UserID; TargetUser : in UserID)
			 return Footsteps is 
   begin
   end ReadFootsteps;
   
   function ReadLocation(Requester : in UserID; TargetUser : in UserID)
			return GPSLocation is
   begin
   end ReadLocation;
   
   procedure ContactEmergency(Wearer : in UserID; 
			      Location : in GPSLocation; 
			      Vitals : in BPM) is
   begin
   end ContactEmergency;
   
   
end AccountManagementSystem;
