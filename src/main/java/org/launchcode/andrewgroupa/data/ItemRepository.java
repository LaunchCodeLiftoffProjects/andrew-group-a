package org.launchcode.andrewgroupa.data;

import org.launchcode.andrewgroupa.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
