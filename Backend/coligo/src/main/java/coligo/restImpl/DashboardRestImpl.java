package coligo.restImpl;

import coligo.service.DashboardService;
import coligo.rest.DashboardRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DashboardRestImpl implements DashboardRest {

    @Autowired
    DashboardService dashboardService;
    @Override
    public ResponseEntity<Map<String, Object>> getData() {
        return dashboardService.getData();
    }
}
