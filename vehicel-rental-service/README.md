# Machine-Coding

**The Challenge**

A Company is starting a new vehicle rental service called RentKar. In this service, we will rent different kinds of vehicles such as cars and bikes.


**Features:**

1.  Rental service has multiple branches throughout the city.
2.  Each branch has a limited number of different kinds of vehicles.
3.  Each vehicle can be booked with a predefined fixed price.
4.  Each vehicle can be booked in multiples of 1-hour slots each. (For simplicity, assume slots of a single day)


**Requirements:**

1.  Onboard a new branch with available vehicles.
2.  Onboard new vehicle(s) of an existing type to a particular branch.
3.  Rent a vehicle for a time slot and a vehicle type(the lowest price as the default choice extendable to any other strategy).
4.  Display available vehicles for a given branch sorted on price.
5.  The vehicle will have to be dropped at the same branch where it was picked up.

## Sample test cases

* ADD_BRANCH b1
* ADD_VEHICLE b1 CAR c1
* LIST_VEHICLE b1 8
* RENT_VEHICLE b1 CAR 8 10
* DROP_VEHICLE b1 c1
```agsl
ADD_BRANCH b1
ADD_VEHICLE b1 Car v1 50
ADD_VEHICLE b1 Car v2 20
LIST_VEHICLE b1 0 23
RENT_VEHICLE b1 Car 0 6
```