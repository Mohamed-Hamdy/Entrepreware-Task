package coligo.rest;


import coligo.POJO.Announcement;
import coligo.POJO.Quiz;
import coligo.wrapper.AnnouncementWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/announcement")
public interface AnnouncementRest {


    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewAnnouncement(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping(path = "/get")
    public ResponseEntity<List<AnnouncementWrapper>> getAllAnnouncement();

    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id);

    @GetMapping(path = "/getAnnouncementById/{id}")
    public ResponseEntity<AnnouncementWrapper> getAnnouncementById(@PathVariable Integer id);

}

