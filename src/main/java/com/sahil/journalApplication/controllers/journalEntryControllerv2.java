package com.sahil.journalApplication.controllers;

import com.sahil.journalApplication.entity.journalEntry;
import com.sahil.journalApplication.services.journalEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/journal")
public class journalEntryControllerv2 {
    @Autowired
    private journalEntryServices journalEntryServices;


    @GetMapping
    public List<journalEntry> getAll(){
        return journalEntryServices.getAllJournals();
    }
    @PostMapping
    public Boolean createEntry(@RequestBody journalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryServices.saveEntry(myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public journalEntry getJournalbyId(@PathVariable ObjectId myId){
        return journalEntryServices.getJournalById(myId).orElse(null); // return type is optional it means there can be data or no data means nul
    }
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalbyId(@PathVariable ObjectId myId){
        journalEntryServices.deleteMapping(myId);
        return true;
    }
    @PutMapping("id/{myId}")
    public journalEntry updateJournalById(@PathVariable ObjectId myId,@RequestBody journalEntry newEntry){
        journalEntry oldEntry = journalEntryServices.getJournalById(myId).orElse(null);
        if(oldEntry!=null){
            oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")? newEntry.getContent() : oldEntry.getContent());
            journalEntryServices.saveEntry(oldEntry);
        }
        else {
            return null;
        }
        return oldEntry;

    }
}
