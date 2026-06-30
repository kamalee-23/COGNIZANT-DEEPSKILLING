import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Test
    public void testWeatherApi() {

        // Create Mock Object
        WeatherApi mockApi = mock(WeatherApi.class);

        // Stub Method
        when(mockApi.getWeather()).thenReturn("Sunny");

        // Test Service
        WeatherService service = new WeatherService(mockApi);

        String result = service.checkWeather();

        // Verify Result
        assertEquals("Sunny", result);

    }

}