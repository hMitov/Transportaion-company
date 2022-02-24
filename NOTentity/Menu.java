package NOTentity;
import DAO.*;
import entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.*;

public class Menu {
    private TransportCompany transportCompany;
    private int countMenuCalls = 0;
    private boolean operationsForManager_MORE = true;


    public void generateObjects() {

        Vehicle vehicle1 = new Vehicle("Mercedes-Benz", "Actros", "E9824PH", LocalDate.of(2000, 5, 14), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3600));
        Vehicle vehicle2 = new Vehicle("Ford", "Transit", "CA7524AA", LocalDate.of(2008, 9, 29), TypeOfVehicle.VAN, 18, BigDecimal.valueOf(2200));
        Vehicle vehicle3 = new Vehicle("Man", "Herpa", "A9912BE", LocalDate.of(2013, 3, 3), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3800));
        Vehicle vehicle4 = new Vehicle("Man", "Herpa", "CB8732PP", LocalDate.of(2015, 1, 10), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3800));
        Vehicle vehicle5 = new Vehicle("Man", "Herpa", "CB5512AA", LocalDate.of(2014, 12, 5), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3800));
        Vehicle vehicle6 = new Vehicle("Man", "Herpa", "C0012CC", LocalDate.of(2004, 8, 10), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3800));
        Vehicle vehicle7 = new Vehicle("Scania", "R450", "CA1238BP", LocalDate.of(2013, 3, 3), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3700));
        Vehicle vehicle8 = new Vehicle("Scania", "R450", "KH4290CP", LocalDate.of(2013, 7, 11), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3700));
        Vehicle vehicle9 = new Vehicle("Scania", "R450", "A9915BE", LocalDate.of(2011, 6, 6), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3700));
        Vehicle vehicle10 = new Vehicle("Renault", "480", "BH2920PP", LocalDate.of(2008, 12, 9), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3900));
        Vehicle vehicle11 = new Vehicle("Renault", "480", "CB8812PB", LocalDate.of(2009, 11, 3), TypeOfVehicle.TRUCK, BigDecimal.valueOf(3900));
        Vehicle vehicle12 = new Vehicle("Mercedes-Benz", "Tourismo", "CB3483HH", LocalDate.of(2004, 2, 4), TypeOfVehicle.BUS, 30, BigDecimal.valueOf(5200));
        Vehicle vehicle13 = new Vehicle("Mercedes-Benz", "Tourismo", "C8613PP", LocalDate.of(2007, 9, 9), TypeOfVehicle.BUS, 30, BigDecimal.valueOf(5200));
        Vehicle vehicle14 = new Vehicle("Mercedes-Benz", "Tourismo", "K2153KH", LocalDate.of(2006, 1, 16), TypeOfVehicle.BUS, 30, BigDecimal.valueOf(5200));
        Vehicle vehicle15 = new Vehicle("Mercedes-Benz", "Sprinter", "EH7298BE", LocalDate.of(2008, 7, 23), TypeOfVehicle.VAN, 12, BigDecimal.valueOf(2100));
        Vehicle vehicle16 = new Vehicle("Mercedes-Benz", "Sprinter", "EH4313CA", LocalDate.of(2013, 1, 31), TypeOfVehicle.VAN, 12, BigDecimal.valueOf(2100));
        Vehicle vehicle17 = new Vehicle("Mercedes-Benz", "Sprinter", "EH4313CA", LocalDate.of(2013, 1, 31), TypeOfVehicle.VAN, 12, BigDecimal.valueOf(2100));



        Driver driver1 = new Driver("Alexander Pavlov", "6674287652",  BigDecimal.valueOf(4900), EmployeePosition.DRIVER, LocalDate.of(2010, 5, 21), DrivingLicenseCategory.D);
        Driver driver2 = new Driver("Zdravko Simeonov", "5527538719",  BigDecimal.valueOf(5350), EmployeePosition.DRIVER, LocalDate.of(2015, 3, 5), DrivingLicenseCategory.DE);
        Driver driver3 = new Driver("Ivan Danielov", "8873522185", BigDecimal.valueOf(3500), EmployeePosition.DRIVER, LocalDate.of(2018, 12, 19), DrivingLicenseCategory.C);
        Driver driver4 = new Driver("Preslav Kolev", "7264927492", BigDecimal.valueOf(4500), EmployeePosition.DRIVER, LocalDate.of(2020, 9, 18), DrivingLicenseCategory.CE);
        Driver driver5 = new Driver("Ruslan Neshev", "6783088784", BigDecimal.valueOf(5500), EmployeePosition.DRIVER, LocalDate.of(2007, 1, 14), DrivingLicenseCategory.DE);
        Driver driver6 = new Driver("Jivko Marinov", "8715266378", BigDecimal.valueOf(5500), EmployeePosition.DRIVER, LocalDate.of(2011, 2, 4), DrivingLicenseCategory.C1);
        Driver driver7 = new Driver("Marin Nikolov", "9109276389",  BigDecimal.valueOf(4500), EmployeePosition.DRIVER, LocalDate.of(2012, 3, 1), DrivingLicenseCategory.C1E);
        Driver driver8 = new Driver("Vladimir Ivanov", "9387108845",  BigDecimal.valueOf(4700), EmployeePosition.DRIVER, LocalDate.of(2016, 7, 7), DrivingLicenseCategory.D1);
        Driver driver9 = new Driver("Daniel Petrov", "8936777266",  BigDecimal.valueOf(4800), EmployeePosition.DRIVER, LocalDate.of(2014, 6, 13), DrivingLicenseCategory.D);
        Driver driver10 = new Driver("Nikolay Bojidarov", "7348022854", BigDecimal.valueOf(5300), EmployeePosition.DRIVER, LocalDate.of(2014, 6, 9), DrivingLicenseCategory.DE);
        Driver driver11 = new Driver("Vasilen Petrov", "9393874463", BigDecimal.valueOf(3700), EmployeePosition.DRIVER, LocalDate.of(2019, 5, 19), DrivingLicenseCategory.CE);



        Coordinator coordinator1 = new Coordinator("Svetla Noteva", "8376455628", BigDecimal.valueOf(2900), EmployeePosition.LOGISTICS_EMPLOYEE, LocalDate.of(2010,6, 9), "004567");
        Coordinator coordinator2 = new Coordinator("Alexandra Ivanova", "9283746534", BigDecimal.valueOf(2800), EmployeePosition.LOGISTICS_EMPLOYEE, LocalDate.of(2013, 6, 29), "008175");
        Coordinator coordinator3 = new Coordinator("Ralica Getova", "7874639954", BigDecimal.valueOf(5600), EmployeePosition.LOGISTICS_MANAGER, LocalDate.of(2017, 2, 7), "995412");
        Coordinator coordinator4 = new Coordinator("Marina Petkova", "5973628636", BigDecimal.valueOf(3400), EmployeePosition.LOGISTICS_EMPLOYEE, LocalDate.of(2019, 9,9), "004232");
        Coordinator coordinator5 = new Coordinator("Ivan Georgiev", "6206982235", BigDecimal.valueOf(3600), EmployeePosition.LOGISTICS_EMPLOYEE, LocalDate.of(2020, 6, 8), "004236");
        Coordinator coordinator6 = new Coordinator("Rostislav Petrov", "6705876354", BigDecimal.valueOf(2800), EmployeePosition.LOGISTICS_EMPLOYEE, LocalDate.of(2012, 3, 2), "001422");
        Coordinator coordinator7 = new Coordinator("Yoana Rashevska", "8473625484", BigDecimal.valueOf(5700), EmployeePosition.LOGISTICS_MANAGER, LocalDate.of(2015, 4, 18), "992655");
        Coordinator coordinator8 = new Coordinator("Stoyan Kolev", "9083766254", BigDecimal.valueOf(5400), EmployeePosition.LOGISTICS_MANAGER, LocalDate.of(2017, 9, 1), "995999");
        Coordinator coordinator9 = new Coordinator("Viktor Todorov", "9187362436", BigDecimal.valueOf(4900), EmployeePosition.LOGISTICS_MANAGER, LocalDate.of(2018, 9, 2), "995532");



        Client client1 = new Client("Coca-Cola", "8 Racho Petkov Kazandzhiyata str, Sofia, Bulgaria", LocalDate.of(2012, 6, 19));
        Client client2 = new Client("OMW", "2 Donka Ushlinova str., Sofia, Bulgaria", LocalDate.of(2005, 8, 22));
        Client client3 = new Client("Coca-Cola", "Batajnicki Drum 14-16, Beograd, Serbia", LocalDate.of(2012, 8, 5));
        Client client4 = new Client("Dertour", "bul. Bulgaria 111A, Sofia, Bulgaria", LocalDate.of(2017, 12, 21));
        Client client5 = new Client("Rad-Festa", "Hristo Belchev 35, Sofia, Bulgaria", LocalDate.of(2012, 6, 6));
        Client client6 = new Client("SofiaAuto", "Okolovrusten put 46, Sofia, Bulgaria", LocalDate.of(2018, 9, 4));
        Client client7 = new Client("Den and Night OOD", "Ivan Momchilov 5, Gorna Oriahovitsa, Bulgaria", LocalDate.of(2015, 2, 4));
        Client client8 = new Client("Rodopeya", "Trakia 20, Smolyan ,Bulgaria", LocalDate.of(2017, 10, 9));
        Client client9 = new Client("Discordia", "Strada Paris nr. 19, Cluj-Napoca 400000, Romania", LocalDate.of(2003, 8, 17));




        Transportation transportation1 = new Transportation("Varna", "Sofia", LocalDateTime.of(2021, 4, 5, 10, 0, 0),
                LocalDateTime.of(2020, 4, 5, 16, 40, 0), client2, TypeOfLoad.PETROL , BigDecimal.valueOf(3900), BigDecimal.valueOf(3000));
        try {
            transportation1.setWeight_in_trailer(BigDecimal.valueOf(2500));
            transportation1.setVehicle(vehicle1);
            transportation1.addDriverToTransportation((Driver) driver2);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation1.getClient().setAllPaidMoney(BigDecimal.valueOf(390800));
        transportation1.getClient().setOwedMoney(BigDecimal.valueOf(3000));
        transportation1.setStatus(Status.FINISHED);



        Transportation transportation2 = new Transportation("Varna", "Blagoevgrad", LocalDateTime.of(2021, 6, 7, 13, 0, 0),
                LocalDateTime.of(2021, 6, 7, 15, 0, 0), client6, TypeOfLoad.CARS , BigDecimal.valueOf(11000), BigDecimal.valueOf(3500));
        try {
            transportation2.setWeight_in_trailer(BigDecimal.valueOf(3100));
            transportation2.setVehicle(vehicle4);
            transportation2.addDriverToTransportation((Driver) driver10);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation2.getClient().setAllPaidMoney(BigDecimal.valueOf(730090));
        transportation2.getClient().setOwedMoney(BigDecimal.valueOf(3500));
        transportation2.setStatus(Status.FINISHED);




        Transportation transportation3 = new Transportation("Sofia", "Budapest", LocalDateTime.of(2021, 10, 3, 7, 0, 0),
                LocalDateTime.of(2021, 10, 3, 23, 30, 0), client5, TypeOfLoad.PASSENGERS , 20, BigDecimal.valueOf(7000));
        try {
            transportation3.setVehicle(vehicle12);
            transportation3.addDriverToTransportation((Driver) driver1);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation3.getClient().setAllPaidMoney(BigDecimal.valueOf(790433));
        transportation3.getClient().setOwedMoney(BigDecimal.valueOf(7000));
        transportation3.setStatus(Status.FINISHED);




        Transportation transportation4 = new Transportation("Sofia", "Thessaloniki", LocalDateTime.of(2021, 12, 30, 8, 0, 0),
                LocalDateTime.of(2021, 12, 30, 15, 40, 0), client6, TypeOfLoad.PASSENGERS, 10, BigDecimal.valueOf(4300));
        try {
            transportation4.setVehicle(vehicle15);
            transportation4.addDriverToTransportation((Driver) driver8);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation4.getClient().setAllPaidMoney(BigDecimal.valueOf(878777));
        transportation4.getClient().setOwedMoney(BigDecimal.valueOf(4300));
        transportation4.setStatus(Status.FINISHED);





        Transportation transportation5 = new Transportation("Thessaloniki", "Sofia", LocalDateTime.of(2022, 1, 2, 13, 0, 0),
                LocalDateTime.of(2022, 1, 2, 21, 0, 0), client6, TypeOfLoad.PASSENGERS, 12, BigDecimal.valueOf(4300));
        try {
            transportation5.setVehicle(vehicle15);
            transportation5.addDriverToTransportation((Driver) driver8);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation5.getClient().setAllPaidMoney(BigDecimal.valueOf(999921));
        transportation5.getClient().setOwedMoney(BigDecimal.valueOf(4300));
        transportation5.setStatus(Status.FINISHED);




        Transportation transportation6 = new Transportation("Sofia", "Plovdiv", LocalDateTime.of(2021, 10, 5, 9, 0, 0),
                LocalDateTime.of(2021, 10, 5, 11, 0, 0), client1, TypeOfLoad.DRINKS , BigDecimal.valueOf(3000), BigDecimal.valueOf(2200));
        try {
            transportation6.setVehicle(vehicle5);
            transportation6.addDriverToTransportation((Driver) driver6);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation6.getClient().setAllPaidMoney(BigDecimal.valueOf(444755));
        transportation6.getClient().setOwedMoney(BigDecimal.valueOf(2200));
        transportation6.setStatus(Status.FINISHED);





        Transportation transportation7 = new Transportation("Sofia", "Vidin", LocalDateTime.of(2021, 11, 8, 6, 0, 0),
                LocalDateTime.of(2021, 11, 8, 10, 0, 0), client2, TypeOfLoad.PETROL , BigDecimal.valueOf(4000), BigDecimal.valueOf(4600));
        try {
            transportation7.setWeight_in_trailer(BigDecimal.valueOf(4500));
            transportation7.setVehicle(vehicle7);
            transportation7.addDriverToTransportation((Driver) driver10);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation7.getClient().setAllPaidMoney(BigDecimal.valueOf(855242));
        transportation7.getClient().setOwedMoney(BigDecimal.valueOf(4600));
        transportation7.setStatus(Status.FINISHED);





        Transportation transportation8 = new Transportation("Varna", "Burgas", LocalDateTime.of(2021, 5, 9, 8, 0, 0),
                LocalDateTime.of(2021, 5, 9, 11, 0, 0), client2, TypeOfLoad.PETROL , BigDecimal.valueOf(5000), BigDecimal.valueOf(1500));
        try {
            transportation8.setVehicle(vehicle7);
            transportation8.addDriverToTransportation((Driver) driver3);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation8.getClient().setAllPaidMoney(BigDecimal.valueOf(990076));
        transportation8.getClient().setOwedMoney(BigDecimal.valueOf(1500));
        transportation8.setStatus(Status.FINISHED);





        Transportation transportation9 = new Transportation("Sofia", "Pernik", LocalDateTime.of(2022, 1, 5, 15, 0, 0),
                LocalDateTime.of(2022, 1, 5, 16, 0, 0), client7, TypeOfLoad.FOOD , BigDecimal.valueOf(2000), BigDecimal.valueOf(500));
        try {
            transportation9.setWeight_in_trailer(BigDecimal.valueOf(3100));
            transportation9.setVehicle(vehicle2);
            transportation9.addDriverToTransportation((Driver) driver11);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation9.getClient().setAllPaidMoney(BigDecimal.valueOf(121912));
        transportation9.getClient().setOwedMoney(BigDecimal.valueOf(500));
        transportation9.setStatus(Status.FINISHED);




        Transportation transportation10 = new Transportation("Sofia", "Pernik", LocalDateTime.of(2022, 1, 10, 12, 0, 0),
                LocalDateTime.of(2022, 1, 10, 15, 0, 0), client7, TypeOfLoad.FOOD , BigDecimal.valueOf(2000), BigDecimal.valueOf(500));
        try {
            transportation10.setVehicle(vehicle2);
            transportation10.addDriverToTransportation((Driver) driver1);
        } catch (DriveLicenseNotAppropriateException | VehicleChoiceException e) {
            e.printStackTrace();
        }
        transportation10.getClient().setAllPaidMoney(BigDecimal.valueOf(321788));
        transportation10.getClient().setOwedMoney(BigDecimal.valueOf(500));
        transportation10.setStatus(Status.FINISHED);




        Set<Transportation> transportations = new TreeSet<Transportation>();
        transportations.add(transportation1);
        transportations.add(transportation2);
        transportations.add(transportation3);
        transportations.add(transportation4);
        transportations.add(transportation5);
        transportations.add(transportation6);
        transportations.add(transportation7);
        transportations.add(transportation8);
        transportations.add(transportation9);
        transportations.add(transportation10);




        Set<Vehicle> vehicles = new TreeSet<Vehicle>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);
        vehicles.add(vehicle6);
        vehicles.add(vehicle7);
        vehicles.add(vehicle8);
        vehicles.add(vehicle9);
        vehicles.add(vehicle10);
        vehicles.add(vehicle11);
        vehicles.add(vehicle12);
        vehicles.add(vehicle13);
        vehicles.add(vehicle14);
        vehicles.add(vehicle15);
        vehicles.add(vehicle16);
        vehicles.add(vehicle17);




        Set<Driver> drivers = new TreeSet<Driver>();
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        drivers.add(driver4);
        drivers.add(driver5);
        drivers.add(driver6);
        drivers.add(driver7);
        drivers.add(driver8);
        drivers.add(driver9);
        drivers.add(driver10);
        drivers.add(driver11);




        Set<Coordinator> coordinators = new TreeSet<Coordinator>();
        coordinators.add(coordinator1);
        coordinators.add(coordinator2);
        coordinators.add(coordinator3);
        coordinators.add(coordinator4);
        coordinators.add(coordinator5);
        coordinators.add(coordinator6);
        coordinators.add(coordinator7);
        coordinators.add(coordinator8);
        coordinators.add(coordinator9);




        Set<Client> clients = new TreeSet<Client>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
        clients.add(client7);
        clients.add(client8);
        clients.add(client9);




        VehicleDAO.saveVehicles(vehicles);
        this.transportCompany.addVehiclesSet(vehicles);

        DriverDAO.saveDrivers(drivers);
        this.transportCompany.addDriversSet(drivers);


        CoordinatorDAO.saveCoordinators(coordinators);
        this.transportCompany.addCoordinatorsSet(coordinators);


        this.transportCompany.addClientsSet(clients);
        ClientDAO.saveClients(clients);

        this.transportCompany.addTransportationsSet(transportations);
        TransportationDAO.saveTransportations(transportations);

    }


    private void Menu_printMenu() {
        System.out.println("\n\n\n");
        System.out.println("                                                                 ********************************************************");
        System.out.println("                                                                *********** Welcome to " + this.transportCompany.getName() + " ***********");
        System.out.println("                                                                 ********************************************************");
    }


    public int logistic_OR_manager(Scanner input) {
        String str;
        do {
            System.out.println("\n\n\n");
            System.out.println("              Hello, please PRESS 0 if you are a LOGISTIC EMPLOYEE or");
            System.out.println("              PRESS 1 if MANAGER!");
            str = input.nextLine();
        } while (!str.equals("0") && !str.equals("1"));
        if (str.equals("1"))
            return 1;
        else
            return 0;
    }


    public void checkIfPasswordIsValid(Scanner input, int count, EmployeePosition employeePosition) {
        boolean continuee = false;
        this.countMenuCalls += 1;
        String str;

        do {
            if(count > 0)
                System.out.println("INVALID password, please TRY AGAIN or PRESS 0 FOR BACK!");
            str = input.nextLine();
            try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<Coordinator> criteriaQuery = criteriaBuilder.createQuery(Coordinator.class);
                Root<Coordinator> root = criteriaQuery.from(Coordinator.class);
                criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("agentPassword"), str), (criteriaBuilder.equal(root.get("employeePosition"), employeePosition))));

                Query<Coordinator> query = session.createQuery(criteriaQuery);
                if(query.getResultList().size() > 0)
                    continuee = true;
            }
            count += 1;
        }while(!continuee && count <= 3);

        if (count > 3 || str.equals(String.valueOf(0))) {
            Menu(input);
        }
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operationsForLogistic_printOptions() {
        System.out.println("                 Please PRESS a number from below to MAKE AN OPERATION: ");
        System.out.println("PRESS 0 TO EXIT 'Logistic mode'");
        System.out.println("PRESS 1 for CHECKING the CLIENTS of Company");
        System.out.println("PRESS 2 for CHANGING ADDRESS of a CLIENT from Company");
        System.out.println("PRESS 3 for INSERTING a new CLIENT");
        System.out.println("PRESS 4 for DELETING a CLIENT");

        System.out.println("PRESS 5 for CHECKING the VEHICLES of Company");
        System.out.println("PRESS 6 for CHANGING the registration plate, ONLY IF IT IS NEW, of a VEHICLE from Company");
        System.out.println("PRESS 7 for INSERTING a new VEHICLE in Company");
        System.out.println("PRESS 8 for DELETING a VEHICLE");

        System.out.println("PRESS 9 for CHECKING the DRIVERS of Company");
        System.out.println("PRESS 10 for UPDATING a DRIVER from Company");
        System.out.println("PRESS 11 for INSERTING a new DRIVER in Company");
        System.out.println("PRESS 12 for DELETING a DRIVER");

        System.out.println("PRESS 13 for CHECKING all TRANSPORTATIONS");
        System.out.println("PRESS 14 for MAKING a new TRANSPORTATION");
        System.out.println("PRESS 15 for DELETING a TRANSPORTATION");
        System.out.println("PRESS 16 to UPDATE Status of TRANSPORTATION");
        System.out.println("PRESS 17 to UPDATE Price of TRANSPORTATION");
        System.out.println("PRESS 18 to UPDATE Driver of TRANSPORTATION");
        System.out.println("PRESS 19 to UPDATE Vehicle of TRANSPORTATION");


        System.out.println("ENTER 20 for FILTERING Drivers by SALARY");
        System.out.println("ENTER 21 for FILTERING Transportations by STARTING POINT");
        System.out.println("ENTER 22 for FILTERING Transportations by ENDING POINT");
        System.out.println("ENTER 23 for FILTERING Transportations by DEPARTURE DATE");
        System.out.println("ENTER 24 for FILTERING Transportations by STATUS and DEPARTURE DATE");
        System.out.println("ENTER 25 for FILTERING Clients by OWED MONEY");
        System.out.println("ENTER 26 for FILTERING Clients by PAID MONEY");
        System.out.println("ENTER 27 for WRITING Transportations report to File");
        System.out.println("ENTER 28 for READING Transportations report from File");
        System.out.println("ENTER 29 for SHOWING ALL FINISHED Transportations and their number");
        System.out.println("ENTER 30 for SHOWING EARNED MONEY from all FINISHED Transportations");
        System.out.println("ENTER 31 for SHOWING Drivers and EARNED money from each");
        System.out.println("ENTER 32 for SHOWING Transportations INCOMES for a Period");


    }



    public void setTransportationVehicle(long id, Scanner input, Vehicle vehicle, Transportation transportation, LocalDateTime departTime, LocalDateTime arrivalTime) {
        boolean ok = false;
        while(!ok) {
            try {
                VehicleDAO.readAllVehicles().stream().forEach(System.out::println);
                System.out.println("Enter ID of a vehicle: ");
                id = input.nextLong();
                input.nextLine();
                vehicle = VehicleDAO.getVehicle(id);
                if(!VehicleDAO.ifVehicleAttendsOtherTransAtSameTime(id, departTime, arrivalTime))
                    throw new Exception("Vehicle is attending other transportation at that time!");
                transportation.setVehicle(vehicle);
                ok = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTransportationDriver(long id, Scanner input, Driver driver, Transportation transportation, LocalDateTime departTime, LocalDateTime arrivalTime) {
        boolean ok = false;
        while(!ok) {
            try {
                DriverDAO.readAllDrivers().stream().forEach(System.out::println);
                System.out.println("Enter ID of a driver: ");
                id = input.nextLong();
                input.nextLine();
                driver = DriverDAO.getDriver(id);
                if(!DriverDAO.ifDriverAttendsOtherTransAtSameTime(id, departTime, arrivalTime))
                    throw new DriverIsBusyWithOtherTransportation("Driver is attending other transportation at that time!");
                transportation.addDriverToTransportation(driver);
                ok = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getTransportation(Transportation transportation, long id, Scanner input) {
        System.out.println(); System.out.println(); System.out.println();
        TransportationDAO.readAllTransportations().stream().forEach(System.out::println);
        System.out.println(); System.out.println(); System.out.println();

        boolean ok = false;
        while(!ok) {
            try {
                System.out.println("Enter the ID of the Transportation: ");
                id = input.nextLong();
                input.nextLine();
                transportation.callCopyConstructor(TransportationDAO.getTransportation(id));
                ok = true;
            } catch (NoResultException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDriver(Driver driver, long id, Scanner input) {
        System.out.println(); System.out.println(); System.out.println();
        DriverDAO.readAllDrivers().stream().forEach(System.out::println);
        System.out.println(); System.out.println(); System.out.println();

        boolean ok = false;
        while(!ok) {
            try {
                System.out.println("Enter the ID of the Driver: ");
                id = input.nextLong();
                input.nextLine();
                driver.callCopyConstructor(DriverDAO.getDriver(id));
                ok = true;
            } catch (NoResultException e) {
                e.printStackTrace();
            }
        }
    }

    public void getVehicle(Vehicle vehicle, long id, Scanner input) {
        System.out.println(); System.out.println(); System.out.println();
        VehicleDAO.readAllVehicles().stream().forEach(System.out::println);
        System.out.println(); System.out.println(); System.out.println();

        boolean ok = false;
        while(!ok) {
            try {
                System.out.println("Enter the ID of the Vehicle: ");
                id = input.nextLong();
                input.nextLine();
                vehicle.callCopyConstructor(VehicleDAO.getVehicle(id));
                ok = true;
            } catch (NoResultException e) {
                e.printStackTrace();
            }
        }
    }

    public void getClient(Client client, long id, Scanner input) {
        System.out.println(); System.out.println(); System.out.println();
        ClientDAO.readAllClients().stream().forEach(System.out::println);
        System.out.println(); System.out.println(); System.out.println();

        boolean ok = false;
        while(!ok) {
            try {
                System.out.println("Enter the ID of the Client: ");
                id = input.nextLong();
                input.nextLine();
                client.callCopyConstructor(ClientDAO.getClient(id));
                ok = true;
            } catch (NoResultException e) {
                e.printStackTrace();
            }
        }
    }

    public void getCoordinator(Coordinator coordinator, long id, Scanner input) {
        System.out.println(); System.out.println(); System.out.println();
        CoordinatorDAO.readAllCoordinators().stream().forEach(System.out::println);
        System.out.println(); System.out.println(); System.out.println();

        boolean ok = false;
        while(!ok) {
            try {
                System.out.println("Enter the ID of the Coordinator: ");
                id = input.nextLong();
                input.nextLine();
                coordinator.callCopyConstructor(CoordinatorDAO.getCoordinator(id));
                ok = true;
            } catch (NoResultException e) {
                e.printStackTrace();
            }
        }
    }


    //gives functionality to cases depends of the manager output
    private void operationsForLogistic_chooseOperation(int i, Scanner input) {
        long id = 0;
        Client client = new Client();
        Vehicle vehicle = new Vehicle();
        Driver driver = new Driver();
        Transportation transportation = new Transportation();
        LocalDateTime departTime = null;
        LocalDateTime arrivalTime = null;


        switch (i) {
            case 1:
                System.out.println();System.out.println();System.out.println();
                ClientDAO.readAllClients().stream().forEach(System.out::println);
                System.out.println();System.out.println();System.out.println();
                break;
            case 2:
                getClient(client, id, input);
                boolean ok = false;
                while (!ok) {
                    try {
                        System.out.println("Enter the new address:");
                        String str = input.nextLine();
                        client.setAddress(str);

                        ClientDAO.createOrUpdate(client);
                        ok = true;
                    } catch (ConstraintViolationException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 3:
                System.out.println();
                System.out.println();
                System.out.println();
                String name = "";
                String address = "";

                ok = false;
                while (!ok) {
                    try {
                        System.out.println("Enter name of Client: ");
                        name = input.nextLine();
                        System.out.println("Enter address of Client:");
                        address = input.nextLine();

                        client = new Client(name, address, LocalDate.now());
                        this.transportCompany.addClient(client);
                        ClientDAO.createOrUpdate(client);
                        ok = true;
                    } catch (ConstraintViolationException e) {
                        this.transportCompany.removeClient(client);
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 4:
                getClient(client, id, input);

                ClientDAO.deleteClient(client);
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 5:
                System.out.println();
                System.out.println();
                System.out.println();
                VehicleDAO.readAllVehicles().stream().forEach(System.out::println);
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 6:
                getVehicle(vehicle, id, input);

                ok = false;
                while (!ok) {
                    try {
                        System.out.println("Enter new registration plate: ");
                        String str = input.nextLine();
                        vehicle.setRegPlate(str);

                        VehicleDAO.createOrUpdate(vehicle);
                        ok = true;
                    } catch (ConstraintViolationException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 7:
                System.out.println();
                System.out.println();
                System.out.println();

                boolean okk = false;
                while(!okk) {
                    try {
                        System.out.println("Enter a brand: ");
                        String brand = input.nextLine();
                        System.out.println("Enter a model: ");
                        String model = input.nextLine();
                        System.out.println("Enter a registration plate: ");
                        String regPlate = input.nextLine();

                        System.out.println("Enter a day: ");
                        int d = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter a month: ");
                        int m = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter a year: ");
                        int y = input.nextInt();
                        input.nextLine();
                        LocalDate parsedLocalDate = null;

                        ok = false;
                        while (!ok) {
                            try {
                                parsedLocalDate = LocalDate.of(y, m, d);
                                ok = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                        BigDecimal empty_weight = null;
                        ok = false;
                        while (!ok) {
                            try {
                                System.out.println("Enter empty_weight of vehicle: ");
                                empty_weight = input.nextBigDecimal();
                                input.nextLine();
                                ok = true;
                            } catch (Exception e) {
                                input.nextLine();
                                e.printStackTrace();
                            }
                        }

                        TypeOfVehicle typeOfVehicle;
                        String str1 = "";

                        ok = false;
                        while (!ok) {
                            System.out.println("ENTER 1 for VAN");
                            System.out.println("ENTER 2 for BUS");
                            System.out.println("ENTER 3 for TRUCK");
                            str1 = input.nextLine();
                            int maxPass = 0;

                            switch (str1) {
                                case "1":
                                    typeOfVehicle = TypeOfVehicle.VAN;
                                    boolean flag = false;
                                    while (!flag) {
                                        try {
                                            System.out.println("Enter MAX number of passengers: ");
                                            maxPass = input.nextInt();
                                            input.nextLine();
                                            if (maxPass > TransportCompany.maxPassengers)
                                                throw new Exception("Max number of passengers is " + TransportCompany.maxPassengers + " !. Try with less people!");
                                            flag = true;
                                        } catch (InputMismatchException ii) {
                                            input.nextLine();
                                            ii.printStackTrace();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    vehicle = new Vehicle(brand, model, regPlate, parsedLocalDate, typeOfVehicle, maxPass, empty_weight);
                                    ok = true;
                                    break;
                                case "2":
                                    typeOfVehicle = TypeOfVehicle.BUS;
                                    flag = false;
                                    while (!flag) {
                                        try {
                                            System.out.println("Enter MAX number of passengers: ");
                                            maxPass = input.nextInt();
                                            input.nextLine();
                                            if (maxPass > TransportCompany.maxPassengers)
                                                throw new Exception("Max number of passengers is " + TransportCompany.maxPassengers + " !. Try with less people!");
                                            flag = true;
                                        } catch (InputMismatchException ii) {
                                            input.nextLine();
                                            ii.printStackTrace();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    vehicle = new Vehicle(brand, model, regPlate, parsedLocalDate, typeOfVehicle, maxPass, empty_weight);
                                    ok = true;
                                    break;
                                case "3":
                                    typeOfVehicle = TypeOfVehicle.TRUCK;
                                    vehicle = new Vehicle(brand, model, regPlate, parsedLocalDate, typeOfVehicle, empty_weight);
                                    ok = true;
                                    break;
                                default:
                                    try {
                                        throw new IllegalArgumentException("There is not such a category!");
                                    } catch (IllegalArgumentException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        }
                        this.transportCompany.addVehicle(vehicle);
                        VehicleDAO.createOrUpdate(vehicle);
                        okk = true;
                    } catch (ConstraintViolationException e) {
                        this.transportCompany.removeVehicle(vehicle);
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            case 8:
                getVehicle(vehicle, id, input);

                VehicleDAO.deleteVehicle(vehicle);
                System.out.println(); System.out.println(); System.out.println();
                break;
            case 9:
                System.out.println(); System.out.println(); System.out.println();
                DriverDAO.readAllDrivers().stream().forEach(System.out::println);
                System.out.println(); System.out.println(); System.out.println();
                break;
            case 10:
                getDriver(driver, id, input);

                okk = false;
                while(!okk) {
                    try {
                        ok = false;
                        String str2 = "";
                        String pos = "";
                        while (!ok) {
                            System.out.println("CHOOSE what to UPDATE");
                            System.out.println("ENTER 1 for SALARY UPDATE");
                            System.out.println("ENTER 2 for DRIVING LICENSE CATEGORY UPDATE");

                            str2 = input.nextLine();
                            switch (str2) {
                                case "1":
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("ENTER a new SALARY: ");

                                    BigDecimal sal = null;
                                    boolean flag = false;
                                    while (!flag) {
                                        try {
                                            sal = input.nextBigDecimal();
                                            input.nextLine();
                                            flag = true;
                                        } catch (InputMismatchException e) {
                                            input.nextLine();
                                            e.printStackTrace();
                                        }
                                    }
                                    driver.setSalary(sal);
                                    ok = true;
                                    break;
                                case "2":
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();

                                    String drc = "";
                                    flag = false;
                                    while (!flag) {
                                        System.out.println("ENTER a new DRIVING LICENSE CATEGORY");
                                        System.out.println("ENTER 1 for C1");
                                        System.out.println("ENTER 2 for C1E");
                                        System.out.println("ENTER 3 for C");
                                        System.out.println("ENTER 4 for CE");
                                        System.out.println("ENTER 5 for D1");
                                        System.out.println("ENTER 6 for D1E");
                                        System.out.println("ENTER 7 for D");
                                        System.out.println("ENTER 8 for DE");
                                        drc = input.nextLine();

                                        switch (drc) {
                                            case "1":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.C1);
                                                flag = true;
                                                break;
                                            case "2":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.C1E);
                                                flag = true;
                                                break;
                                            case "3":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.C);
                                                flag = true;
                                                break;
                                            case "4":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.CE);
                                                flag = true;
                                                break;
                                            case "5":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.D1);
                                                flag = true;
                                                break;
                                            case "6":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.D1E);
                                                flag = true;
                                                break;
                                            case "7":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.D);
                                                flag = true;
                                                break;
                                            case "8":
                                                driver.setDrivingLicenseCategory(DrivingLicenseCategory.DE);
                                                flag = true;
                                                break;
                                            default:
                                                try {
                                                    throw new IllegalArgumentException("There is not such a category!");
                                                } catch (IllegalArgumentException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                        }
                                    }
                                    ok = true;
                                    break;
                                default:
                                    try {
                                        throw new IllegalArgumentException("There is not such a option!");
                                    } catch (IllegalArgumentException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        }
                        DriverDAO.createOrUpdate(driver);
                        okk = true;
                    } catch (ConstraintViolationException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 11:
                System.out.println(); System.out.println(); System.out.println();
                String egn = "";
                String name1 = "";
                okk = false;
                while(!okk) {
                    try {
                        System.out.println("ENTER the Name of the new Employee: ");
                        name1 = input.nextLine();
                        ok = false;
                        while (!ok) {
                            try {
                                System.out.println("ENTER the Egn of the new Employee: ");
                                egn = input.nextLine();
                                if (egn.length() != 10)
                                    throw new Exception("EGN length should be 10 numbers long!");
                                ok = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        ok = false;
                        DrivingLicenseCategory drivingLicenseCategory = null;
                        while (!ok) {
                            System.out.println("ENTER the Driving License Category of the new Employee: ");
                            String dlc = input.nextLine();
                            try {
                                drivingLicenseCategory = DrivingLicenseCategory.valueOf(dlc);
                                ok = true;
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                        }


                        ok = false;
                        BigDecimal salary = null;
                        while (!ok) {
                            try {
                                System.out.println("ENTER the salary of the Employee: ");
                                salary = input.nextBigDecimal();
                                input.nextLine();
                                ok = true;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                                e.printStackTrace();
                            }
                        }

                        driver = new Driver(name1, egn, salary, EmployeePosition.DRIVER, LocalDate.now(), drivingLicenseCategory);                this.transportCompany.addDriver(driver);
                        this.transportCompany.addDriver(driver);
                        DriverDAO.createOrUpdate(driver);
                        okk = true;
                    } catch (ConstraintViolationException e) {
                        this.transportCompany.removeDriver(driver);
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            case 12:
                getDriver(driver, id, input);

                DriverDAO.deleteDriver(driver.getId());
                break;
            case 13:
                System.out.println(); System.out.println(); System.out.println();
                TransportationDAO.readAllTransportations().stream().forEach(System.out::println);
                System.out.println(); System.out.println(); System.out.println();
                break;
            case 14:
                System.out.println(); System.out.println(); System.out.println();

                int yy = 0;
                int mm = 0;
                int dd = 0;
                int h = 0;
                int minut = 0;
                BigDecimal price = null;
                okk = false;
                while(!okk) {
                    try {

                        System.out.println("ENTER the departPoint: ");
                        String departPoint = input.nextLine();

                        System.out.println("ENTER the arrivalPoint: ");
                        String arrivalPoint = input.nextLine();


                        ok = false;
                        while (!ok) {
                            try {
                                System.out.println("Enter depart time");
                                System.out.println("Enter year: ");
                                yy = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter month: ");
                                mm = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter day: ");
                                dd = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter hour: ");
                                h = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter minutes: ");
                                minut = input.nextInt();
                                input.nextLine();
                                departTime = LocalDateTime.of(yy, mm, dd, h, minut);

                                System.out.println("Enter arrival time");
                                System.out.println("Enter year: ");
                                yy = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter month: ");
                                mm = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter day: ");
                                dd = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter hour: ");
                                h = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter minutes: ");
                                minut = input.nextInt();
                                input.nextLine();
                                arrivalTime = LocalDateTime.of(yy, mm, dd, h, minut);
                                if(departTime.isAfter(arrivalTime))
                                    throw new Exception("Departure dateTime should be before arrival dateTime");
                                ok = true;
                            } catch (DateTimeException e) {
                                e.printStackTrace();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }

                        getClient(client, id, input);

                        TypeOfLoad typeOfLoad = null;

                        ok = false;
                        while (!ok) {
                            System.out.println("Enter typeOfLoad");
                            System.out.println("ENTER 1 for PASSENGERS");
                            System.out.println("ENTER 2 for PETROL");
                            System.out.println("ENTER 3 for CARS");
                            System.out.println("ENTER 4 for FOOD");
                            System.out.println("ENTER 5 for DRINKS");
                            System.out.println("ENTER 6 for FLAMMABLE_LIQUIDS");

                            String ch = input.nextLine();
                            switch (ch) {
                                case "1":
                                    typeOfLoad = TypeOfLoad.PASSENGERS;
                                    ok = true;
                                    break;
                                case "2":
                                    typeOfLoad = TypeOfLoad.PETROL;
                                    ok = true;
                                    break;
                                case "3":
                                    typeOfLoad = TypeOfLoad.CARS;
                                    ok = true;
                                    break;
                                case "4":
                                    typeOfLoad = TypeOfLoad.FOOD;
                                    ok = true;
                                    break;
                                case "5":
                                    typeOfLoad = TypeOfLoad.DRINKS;
                                    ok = true;
                                    break;
                                case "6":
                                    typeOfLoad = TypeOfLoad.FLAMMABLE_LIQUIDS;
                                    ok = true;
                                    break;
                                default:
                                    try {
                                        throw new IllegalArgumentException("There is not such a category!");
                                    } catch (IllegalArgumentException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            }
                        }

                        ok = false;
                        while (!ok) {
                            try {
                                System.out.println("Enter price of delivery: ");
                                price = input.nextBigDecimal();
                                input.nextLine();
                                ok = true;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                                e.printStackTrace();
                            }
                        }

                        int numberOfPassengers = 0;

                        ok = false;
                        while (!ok) {
                            try {
                                System.out.println("Enter number of passengers: ");
                                numberOfPassengers = input.nextInt();
                                input.nextLine();
                                if (numberOfPassengers > TransportCompany.maxPassengers)
                                    throw new Exception("Max number of passengers is " + TransportCompany.maxPassengers + " !. Try with less people!");
                                ok = true;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                                e.printStackTrace();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }

                        BigDecimal weightInTruck = null;

                        if (typeOfLoad != TypeOfLoad.PASSENGERS) {
                            ok = false;
                            while (!ok) {
                                try {
                                    System.out.println("Enter weight in truck: ");
                                    weightInTruck = input.nextBigDecimal();
                                    input.nextLine();
                                    ok = true;
                                } catch (InputMismatchException e) {
                                    input.nextLine();
                                    e.printStackTrace();
                                }
                            }
                        }

                        System.out.println("Shall a trailer be placed: ");
                        int b = 0;
                        do {
                            System.out.println("Enter 1 for YES or 2 for NO");
                            b = input.nextInt();
                            input.nextLine();
                        } while (b < 1 || b > 2);

                        BigDecimal weightInTrailer = null;

                        if (b == 1) {
                            ok = false;
                            while (!ok) {
                                try {
                                    System.out.println("Enter trailer weight: ");
                                    weightInTrailer = input.nextBigDecimal();
                                    input.nextLine();
                                    ok = true;
                                } catch (InputMismatchException e) {
                                    input.nextLine();
                                    e.printStackTrace();
                                }
                            }
                        }

                        transportation = new Transportation(departPoint, arrivalPoint, departTime, arrivalTime, client, typeOfLoad,
                                weightInTruck, weightInTrailer, numberOfPassengers, price);
                        transportation.getClient().setOwedMoney(transportation.getPrice());
                        transportation.setStatus(Status.NOT_FINISHED);


                        ok = false;
                        while (!ok) {
                            try {
                                VehicleDAO.readAllVehicles().stream().forEach(System.out::println);
                                System.out.println("Enter ID of a vehicle: ");
                                id = input.nextLong();
                                input.nextLine();
                                vehicle = VehicleDAO.getVehicle(id);
                                if (!VehicleDAO.ifVehicleAttendsOtherTransAtSameTime(id, departTime, arrivalTime))
                                    throw new Exception("Vehicle is attending other transportation at that time!");
                                transportation.setVehicle(vehicle);
                                ok = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }


                        ok = false;
                        while (!ok) {
                            try {
                                DriverDAO.readAllDrivers().stream().forEach(System.out::println);
                                System.out.println("Enter ID of a driver: ");
                                id = input.nextLong();
                                input.nextLine();
                                driver = DriverDAO.getDriver(id);
                                if (!DriverDAO.ifDriverAttendsOtherTransAtSameTime(id, departTime, arrivalTime))
                                    throw new DriverIsBusyWithOtherTransportation("Driver is attending other transportation at that time!");
                                transportation.addDriverToTransportation(driver);
                                ok = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        this.transportCompany.addTransportation(transportation);
                        TransportationDAO.saveTransportation(transportation);
                        ClientDAO.createOrUpdate(transportation.getClient());
                        okk = true;
                    } catch (ConstraintViolationException e) {
                        this.transportCompany.removeTransportation(transportation);
                        e.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                break;
            case 15:
                getTransportation(transportation, id, input);

                TransportationDAO.deleteTransportation(transportation);
                System.out.println(); System.out.println(); System.out.println();
                break;
            case 16:
                getTransportation(transportation, id, input);

                transportation.changeStatusToFinished();
                TransportationDAO.createOrUpdate(transportation);
                ClientDAO.createOrUpdate(transportation.getClient());
                break;
            case 17:
                getTransportation(transportation, id, input);

                price = null;
                okk = false;
                while(!okk) {
                    try {
                        ok = false;
                        while (!ok) {
                            try {
                                System.out.println("Enter price of delivery: ");
                                price = input.nextBigDecimal();
                                input.nextLine();
                                ok = true;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                                e.printStackTrace();
                            }
                        }
                        transportation.setPrice(price);
                        TransportationDAO.createOrUpdate(transportation);
                        okk = true;
                    } catch (ConstraintViolationException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 18:
                getTransportation(transportation, id, input);

                setTransportationDriver(id, input, driver, transportation, transportation.getDepartTime(), transportation.getArrivalTime());
                TransportationDAO.createOrUpdate(transportation);
                break;
            case 19:
                getTransportation(transportation, id, input);

                setTransportationVehicle(id, input, vehicle, transportation, transportation.getDepartTime(), transportation.getArrivalTime());
                TransportationDAO.createOrUpdate(transportation);
                break;
            case 20:
                DriverDAO.filterDriversBySalary().stream().forEach(System.out::println);
                break;
            case 21:
                TransportationDAO.filterTransportationsByStartingPoint().stream().forEach(System.out::println);
                break;
            case 22:
                TransportationDAO.filterTransportationsByEndingPoint().stream().forEach(System.out::println);
                break;
            case 23:
                TransportationDAO.filterTransportationsByStartingDate().stream().forEach(System.out::println);
                break;
            case 24:
                TransportationDAO.filterTransportationsByStatusThenDepartTime().stream().forEach(System.out::println);
                break;
            case 25:
                ClientDAO.filterClientsOwedMoney().stream().forEach(System.out::println);
                break;
            case 26:
                ClientDAO.filterClientsPaidMoney().stream().forEach(System.out::println);
                break;
            case 27:
                TransportationDAO.putAllTransportationsInFile();
                break;
            case 28:
                TransportationDAO.readAllTransportationsFromFile().stream().forEach(System.out::println);
                break;
            case 29:
                TransportationDAO.transportationsWithFinishedStatus().stream().forEach(System.out::println);
                break;
            case 30:
                System.out.println(TransportationDAO.moneyFromAllFinishedTransportations());
                break;
            case 31:
                DriverDAO.readAllDrivers().stream().forEach(dr -> {
                    DriverDAO.getDriversTransportations(dr.getId());
                });
                break;
            case 32:
                LocalDateTime minimum = null;
                LocalDateTime maximum = null;
                ok = false;
                while(!ok) {
                    try {
                        System.out.println("Enter minimum date time");
                        System.out.println("Enter year: ");
                        yy = input.nextInt();input.nextLine();
                        System.out.println("Enter month: ");
                        mm = input.nextInt();input.nextLine();
                        System.out.println("Enter day: ");
                        dd = input.nextInt();input.nextLine();
                        System.out.println("Enter hour: ");
                        h = input.nextInt(); input.nextLine();
                        System.out.println("Enter minutes: ");
                        minut = input.nextInt(); input.nextLine();
                        minimum = LocalDateTime.of(yy, mm, dd, h, minut);
                        ok = true;
                    } catch (DateTimeException e) {
                        e.printStackTrace();
                    }
                }


                ok = false;
                while(!ok) {
                    try {
                        System.out.println("Enter arrival time");
                        System.out.println("Enter year: ");
                        yy = input.nextInt();input.nextLine();
                        System.out.println("Enter month: ");
                        mm = input.nextInt();input.nextLine();
                        System.out.println("Enter day: ");
                        dd = input.nextInt();input.nextLine();
                        System.out.println("Enter hour: ");
                        h = input.nextInt(); input.nextLine();
                        System.out.println("Enter minutes: ");
                        minut = input.nextInt(); input.nextLine();
                        maximum = LocalDateTime.of(yy, mm, dd, h, minut);
                        ok = true;
                    } catch (DateTimeException e) {
                        e.printStackTrace();
                    }
                }

                TransportationDAO.incomeFromTransportationsForAPeriod(minimum, maximum);
                break;
        }
    }




    public void operationsForLogistic_inputOperation(Scanner input) {
        int i = 0;

        boolean ok = false;
        while(!ok) {
            try {
                i = input.nextInt();
                input.nextLine();
                if (i > 32)
                    throw new IndexOutOfBoundsException("There IS NO such an operation!");
                ok = true;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        if (i == 0) {
            operationsForManager_MORE = false;
            Menu(input);
        } else {
            operationsForLogistic_chooseOperation(i, input);
        }
    }


    public void operationsForLogistic(Scanner input) {
        while (operationsForManager_MORE) {
            operationsForLogistic_printOptions();
            operationsForLogistic_inputOperation(input);
        }
    }


    public void logisticPassword_Input(Scanner input, int count) {
        System.out.println("\t.....Please ENTER logistic password.....");
        checkIfPasswordIsValid(input, count, EmployeePosition.LOGISTICS_EMPLOYEE);
        operationsForLogistic(input);
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void operationsForManager_chooseOperation(int i, Scanner input) {
        Coordinator coordinator = new Coordinator();
        long id = 0;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            switch (i) {
                case 33:
                    System.out.println();System.out.println();System.out.println();
                    CoordinatorDAO.readAllCoordinators().stream().forEach(System.out::println);
                    System.out.println();System.out.println();System.out.println();
                    break;
                case 34:
                    System.out.println(); System.out.println(); System.out.println();
                    boolean okk = false;
                    while(!okk) {
                        try {
                            System.out.println("ENTER the Name of the new Employee: ");
                            String name1 = input.nextLine();

                            String egn = "";

                            boolean ok = false;
                            while (!ok) {
                                try {
                                    System.out.println("ENTER the Egn of the new Employee: ");
                                    egn = input.nextLine();
                                    if (egn.length() != 10)
                                        throw new Exception("EGN length should be 10 numbers long!");
                                    ok = true;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            ok = false;
                            EmployeePosition employeePosition = null;
                            while (!ok) {
                                System.out.println("ENTER the Employee Position of the new Employee: ");
                                String empPos = input.nextLine();
                                try {
                                    employeePosition = EmployeePosition.valueOf(empPos);
                                    ok = true;
                                } catch (IllegalArgumentException e) {
                                    e.printStackTrace();
                                }
                            }

                            ok = false;
                            BigDecimal salary = null;
                            while (!ok) {
                                try {
                                    System.out.println("ENTER the salary of the Employee: ");
                                    salary = input.nextBigDecimal();
                                    input.nextLine();
                                    ok = true;
                                } catch (InputMismatchException e) {
                                    input.nextLine();
                                    e.printStackTrace();
                                }
                            }

                            String agent = "";

                            ok = false;
                            while (!ok) {
                                try {
                                    System.out.println("ENTER an Agent password for the new Employee: ");
                                    agent = input.nextLine();
                                    if (agent.length() != 6)
                                        throw new Exception("Agent length should be 6 numbers long!");
                                    ok = true;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            coordinator = new Coordinator(name1, egn, salary, employeePosition, LocalDate.now(), agent);
                            this.transportCompany.addCoordinator(coordinator);
                            CoordinatorDAO.saveCoordiantor(coordinator);
                            okk = true;
                        } catch (ConstraintViolationException e) {
                            this.transportCompany.removeCoordinator(coordinator);
                            e.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;
                case 35:
                    getCoordinator(coordinator, id, input);

                    CoordinatorDAO.deleteCoordinator(coordinator.getId());
                    break;
                case 36:
                    CoordinatorDAO.filterCoordinatorsBySalary().stream().forEach(System.out::println);
                    break;
                case 37:
                    CoordinatorDAO.filterCoordinatorsByPosition().stream().forEach(System.out::println);
                    break;
            }
        }
    }


   // public void operationsForManager_chooseOperation(i, Scanner input)
    private void operationsForManager_printOptions() {
        operationsForLogistic_printOptions();
        System.out.println("PRESS 33 for CHECKING the Coordinators of Company");
        System.out.println("PRESS 34 for INSERTING a new Coordinator in Company");
        System.out.println("ENTER 35 for DELETION a Coordinator from Company");
        System.out.println("ENTER 36 for FILTERING Coordinators by SALARY");
        System.out.println("ENTER 37 for FILTERING Coordinators by POSITION");
    }



    //input the wanted operation of manager
    private void operationsForManager_inputOperation(Scanner input) {
        int i = 0;

        boolean ok = false;
        while(!ok) {
            try {
                i = input.nextInt();
                input.nextLine();
                if (i > 37)
                    throw new IndexOutOfBoundsException("There IS NO such an operation!");
                ok = true;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        if (i == 0) {
            operationsForManager_MORE = false;
            Menu(input);
        } else {
            if(i < 33)
                operationsForLogistic_chooseOperation(i, input);
            else
                operationsForManager_chooseOperation(i, input);
        }
    }



    public void operationsForManager(Scanner input) {
        while (operationsForManager_MORE) {
            operationsForManager_printOptions();
            operationsForManager_inputOperation(input);
        }
    }




    //checks if inputted password matches original

    private void managerPassword_Input(Scanner input, int count) {
        System.out.println("\t.....Please ENTER manager password.....");
        checkIfPasswordIsValid(input, count, EmployeePosition.LOGISTICS_MANAGER);
        operationsForManager(input);
    }



    public void Menu(Scanner input) {
        this.transportCompany = new TransportCompany("BgTransportAndLogistics", LocalDate.of(1990, 6, 27));
       // generateObjects();
        Menu_printMenu();
        int count = 0;
        int exit = 0;

        if (this.countMenuCalls > 0) {
            System.out.println("PRESS 0 IF YOU WANT TO EXIT PROGRAM or any other BUTTON to continue in programme");
            exit = input.nextInt();
            if (exit == 0)
                return;
            else
                input.nextLine();
        }

        if (logistic_OR_manager(input) == 1) {
            managerPassword_Input(input, count);
        } else {
            logisticPassword_Input(input, count);
        }
    }
}
