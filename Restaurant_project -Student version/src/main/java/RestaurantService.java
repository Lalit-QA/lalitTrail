import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

//    public Restaurant findRestaurantByName(String restaurantName){
//        for (Restaurant restaurant : restaurants) {
//            if (restaurant.getName().equals(restaurantName)) {
//                return restaurant;
//            }
//        }
//        return null;
//        //DELETE ABOVE STATEMENT AND WRITE CODE HERE - corrected above code
//    }
    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
        }
        throw new restaurantNotFoundException(restaurantName); // Throw the exception if restaurant is not found
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
