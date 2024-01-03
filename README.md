Sure, here is a documentation of the project:

# ParkingGarage

This project contains a class called ParkingGarage, which represents a parking garage. The class manages the parking spots and records the parking history.

## Package: org.lecture

The package org.lecture contains the ParkingGarage class.

## Class: ParkingGarage

The ParkingGarage class has the following attributes and methods:

- **spots**: A Semaphore object that is used to control the number of spots in the parking garage.
- **ioHandler**: An IOHandler object that is used to manage the user interaction (input and output).
- **parkingHistoryManager**: A ParkingHistoryManager object that is used to record the parking history.
- **dateTimeFormatter**: A DateTimeFormatter object that is used to format the time stamp for the parking events.

The constructor of the ParkingGarage class takes an IOHandler object and a capacity parameter, which represents the number of spots in the parking garage. If the ioHandler parameter is null, an IllegalArgumentException is thrown.

The enterGarage method is used to park a car in the parking garage. It adds an entry to the parking history with the current time stamp, the license plate of the car, and the message "möchte einfahren". It then tries to acquire a spot from the Semaphore object, and if successful, adds another entry to the parking history with the current time stamp, the license plate of the car, and the message "eingeparkt".

The leaveGarage method is used to release a parking spot that was previously occupied by a car. It adds an entry to the parking history with the current time stamp, the license plate of the car, and the message "Verlässt das Parkhaus". It then releases the spot back to the Semaphore object.

The clearHistory method is used to clear the history of the parking garage. It simply calls the clearHistory method of the ParkingHistoryManager object.

The getHistory method returns a list of HistoryEntry objects, which represents the parking history.

## Interfaces: IOHandler

The IOHandler interface defines the methods that are used to manage the user interaction (input and output). The interface is implemented by a specific class that provides the actual implementation for the methods.

## Class: ParkingHistoryManager

The ParkingHistoryManager class is used to record the parking history. It has the following attributes:

- **ioHandler**: An IOHandler object that is used to manage the user interaction (input and output).
- **history**: A list of HistoryEntry objects that represents the parking history.

The constructor of the ParkingHistoryManager class takes an IOHandler object.

The addEntry method is used to add a new entry to the parking history. It takes a HistoryEntry object that contains the time stamp, the license plate of the car, and the event message. It then adds the entry to the history list.

The clearHistory method is used to clear the history of the parking garage. It simply sets the history list to an empty list.

The getHistory method returns a list of HistoryEntry objects, which represents the parking history.

## Class: HistoryEntry

The HistoryEntry class represents an entry in the parking history. It has the following attributes:

- **timeStamp**: A string that represents the time stamp of the event.
- **licensePlate**: A string that represents the license plate of the car.
- **eventMessage**: A string that represents the event message.

The constructor of the HistoryEntry class takes the time stamp, the license plate, and the event message as parameters.

## Conclusion

In summary, this project contains a class called ParkingGarage, which represents a parking garage. The class manages the parking spots and records the parking history. The project also includes an IOHandler interface and a ParkingHistoryManager class, which are used to manage the user interaction and record the parking history, respectively.