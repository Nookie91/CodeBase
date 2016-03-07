with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;

with Measures; use Measures;
with AccountManagementSystem;

-- This procedure demonstrates a simple user of AccountManagementSystem.
procedure Example is
   Wearer : UserID;
   Location : GPSLocation := (90.0, 0.0); 
   Vitals : BPM := 100;
begin
   AccountManagementSystem.Init;
   Wearer := AccountManagementSystem.CreateUser;
   AccountManagementSystem.ContactEmergency(Wearer, Location, Vitals);
end Example;
