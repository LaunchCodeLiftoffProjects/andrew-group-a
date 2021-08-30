package org.launchcode.andrewgroupa.data;

import org.launchcode.andrewgroupa.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Integer> {
}
