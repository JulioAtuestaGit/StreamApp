/* adds productions to table production if those are not yet
* add production to history
* add production to favorites
* */
package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductionSelectionComponent {
    @Autowired
    IProductionService iProductionService;

//    @Autowired
//    IAddingTitleService ?
}
