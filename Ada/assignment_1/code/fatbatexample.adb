with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

with Measures; use Measures;
with AccountManagementSystem;

-- This procedure demonstrates a simple user of AccountManagementSystem.
package body FatBatExample is

-- Initialise the variables
   Wearer : UserID;
   Friend : UserID;
   Insurance : UserID;
   Location : GPSLocation := (90.0, 0.0); 
   Vitals : BPM := 100;
   Steps : Footsteps := 24;

-- Create three new users, the Wearer, his Friend and his Insurer.
   procedure CreateUsers is
   begin
      Wearer := AccountManagementSystem.CreateUser;
      Friend := AccountManagementSystem.CreateUser;
      Insurance := AccountManagementSystem.CreateUser;
   end CreateUsers;

-- Set the Wearer and Friend
   procedure SetConnections is
   begin
      AccountManagementSystem.SetFriend(Wearer,Friend);
      AccountManagementSystem.SetInsurer(Wearer,Insurance);
   end SetConnections;

-- Update the Wearer's Footsteps and Vitals.
   procedure UpdateData is
   begin
      AccountManagementSystem.UpdateVitals(Wearer, Vitals);
      AccountManagementSystem.UpdateFootsteps(Wearer, Steps);
      Put_Line("User " & UserID'Image(Wearer) & ":");
      Steps := AccountManagementSystem.ReadFootsteps(Wearer, Wearer);
      Put_Line("Has walked: " & Footsteps'Image(Steps));
      Vitals := AccountManagementSystem.ReadVitals(Wearer, Wearer);
      Put_Line("Has BPM: " & BPM'Image(Vitals));
   end UpdateData;

-- Change the Wearer's Vitals permission to allow Emergency to read.
   procedure ChangePermissions is
   begin 
      AccountManagementSystem.UpdateVitalsPermissions(Wearer,0,True);
   end ChangePermissions;

-- Call ContactEmergency.
   procedure CardiacArrest is
   begin 
      Location := (10.0,10.0);
      Vitals := 10;
      AccountManagementSystem.ContactEmergency(Wearer,Location,Vitals);
   end CardiacArrest;

-- Initialise AccountManagementSystem then call the procedures above.
   procedure Run is
   begin
      AccountManagementSystem.Init;
      CreateUsers;
      SetConnections;
      UpdateData;
      ChangePermissions;
      CardiacArrest;
   end Run;

end FatBatExample;
