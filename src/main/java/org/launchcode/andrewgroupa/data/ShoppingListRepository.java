package org.launchcode.andrewgroupa.data;

import org.launchcode.andrewgroupa.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
}
