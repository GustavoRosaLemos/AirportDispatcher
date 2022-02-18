package controller;

import model.Package;
import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseController {
    public static int addPackage(String packageType, String packageCategory, String owner, int weight, String weightType) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Package aPackage = Package.builder()
                .packageType(packageType)
                .packageCategory(packageCategory)
                .owner(owner)
                .weight(weight)
                .weightType(weightType)
                .build();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aPackage);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return aPackage.getId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return -1;
    }

    public static int addTransportData(int packageId, int flightId, String cargo) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TransportData transportData = TransportData.builder().packageId(packageId).flightId(flightId).cargo(cargo).build();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(transportData);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return transportData.getId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return -1;
    }

    public static TransportData getTransportData(int packageId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TransportData transportData = entityManager.find(TransportData.class, packageId);
            entityManager.close();
            entityManagerFactory.close();
            return transportData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    public static User getUser(String username, String password) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            User user = (User) entityManager.createQuery("from User where username =:username and password =:password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            entityManager.close();
            entityManagerFactory.close();
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    public static List<Airport> getAirports() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<Airport> airports = new ArrayList<>();
        try {
            airports = (ArrayList<Airport>) entityManager.createQuery("from Airport").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return airports;
    }

    public static Plane getPlane(String callsign) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Plane plane = (Plane) entityManager.createQuery("from Plane where callsign =:callsign")
                    .setParameter("callsign", callsign)
                    .getSingleResult();
            entityManager.close();
            entityManagerFactory.close();
            return plane;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    public static List<Plane> getPlanes() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<Plane> planes = new ArrayList<Plane>();
        try {
            planes = (ArrayList<Plane>) entityManager.createQuery("from Plane").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return planes;
    }

    public static List<Flight> getFlights() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            flights = (ArrayList<Flight>) entityManager.createQuery("from Flight").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return flights;
    }

    public static List<Flight> getFlights(String planeCallsign) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            flights = (ArrayList<Flight>) entityManager.createQuery("from Flight where planeCallsign =:planeCallsign")
                    .setParameter("planeCallsign", planeCallsign)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return flights;
    }

    public static Flight getFlight(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Flight flight = entityManager.find(Flight.class, id);
            entityManager.close();
            entityManagerFactory.close();
            return flight;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    public static Package getPackage(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Package aPackage = entityManager.find(Package.class, id);
            entityManager.close();
            entityManagerFactory.close();
            return aPackage;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    public static List<Package> getPackages() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<Package> packages = new ArrayList<Package>();
        try {
            packages = (ArrayList<Package>) entityManager.createQuery("from Package").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return packages;
    }

    public static int addPackageHistory(int packageId, String action, String author) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PackageHistory packageHistory = PackageHistory.builder().packageId(packageId).action(action).author(author).createdAt(LocalDateTime.now().toString()).build();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(packageHistory);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return packageHistory.getPackageId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return -1;
    }

    public static List<PackageHistory> getPackageHistories() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<PackageHistory> packageHistories = new ArrayList<PackageHistory>();
        try {
            packageHistories = (ArrayList<PackageHistory>) entityManager.createQuery("from PackageHistory").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return packageHistories;
    }

    public static List<PackageHistory> getPackageHistories(int packageId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ArrayList<PackageHistory> packageHistories = new ArrayList<PackageHistory>();
        try {
            packageHistories = (ArrayList<PackageHistory>) entityManager.createQuery("from PackageHistory where id =:id")
                    .setParameter("id", packageId)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return packageHistories;
    }
}
