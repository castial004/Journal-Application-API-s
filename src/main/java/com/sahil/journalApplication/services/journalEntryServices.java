package com.sahil.journalApplication.services;
import com.sahil.journalApplication.entity.journalEntry;
import com.sahil.journalApplication.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryServices {
    @Autowired
    private journalEntryRepository journalEntryRepository;
    public void saveEntry(journalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public List<journalEntry> getAllJournals(){
       return journalEntryRepository.findAll();
    }
    public Optional<journalEntry> getJournalById(ObjectId myId){
        return journalEntryRepository.findById(myId);
    }
    public void deleteMapping(ObjectId myId){
        journalEntryRepository.deleteById(myId);
    }
}
