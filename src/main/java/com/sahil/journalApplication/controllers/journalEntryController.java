package com.sahil.journalApplication.controllers;

import com.sahil.journalApplication.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class journalEntryController {
    // to store data we create a hash map(dictionary)
    // map has 2 parameter one is key another is value, key will be our id and value will be
    // Object of journalEntry
    private Map<ObjectId, journalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<journalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public Boolean createEntry(@RequestBody journalEntry myEntry){ // @requestbody tells the spring boot to fetch data from request body and turn it into a java object
        //of class journalentry and the object name will be myentry
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public journalEntry getJournalbyId(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public journalEntry deleteJournalbyId(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }
    @PutMapping("id/{myId}")
    public journalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody journalEntry myEntry){
        return journalEntries.put(myId,myEntry);
    }
}
