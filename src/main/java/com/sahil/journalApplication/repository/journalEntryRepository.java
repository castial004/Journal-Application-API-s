package com.sahil.journalApplication.repository;

import com.sahil.journalApplication.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
// here mongorepsitory<T,ID> is a generics
// where T means entity type and ID means entity id's type
public interface journalEntryRepository extends MongoRepository<journalEntry, ObjectId> {
    // at run time Spring boot will create implementation of this interface
}
