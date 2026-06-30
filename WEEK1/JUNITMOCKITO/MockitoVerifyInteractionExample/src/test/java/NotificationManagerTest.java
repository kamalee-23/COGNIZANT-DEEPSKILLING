import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NotificationManagerTest {

    @Test
    public void testVerifyInteraction() {

        // Step 1: Create Mock Object
        NotificationService mockService = mock(NotificationService.class);

        // Step 2: Create Object Using Mock
        NotificationManager manager = new NotificationManager(mockService);

        // Step 3: Call Method
        manager.notifyUser();

        // Step 4: Verify Interaction
        verify(mockService).sendNotification("Order Confirmed");

    }

}