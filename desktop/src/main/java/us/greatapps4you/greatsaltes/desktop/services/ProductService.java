/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsales.usecases.DataProcessor;
import us.greatapps4you.greatsaltes.desktop.repositories.ProductRepository;

import java.util.UUID;
import java.util.function.Function;

@Service
public class ProductService {

    private DataProcessor<UUID, Product> deleting = () -> {};
    private DataProcessor<Product, Product> saving = () -> {};

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {

        Function<Product, Product> saveAlgorithm = (p) -> {
            if (p.getUuid() == null) {
                p.setUuid(UUID.randomUUID());
            }
            return repository.save(p);
        };

        return saving.process(product, saveAlgorithm);
    }

    public Product delete(UUID uuid) {
        
        Function<UUID, Product> deleteAlgorithm = (u) -> {
            Product retrieved = repository.findById(u).orElse(null);
            if(retrieved != null) {
                repository.delete(retrieved);
            }
            return retrieved;
        };

        return deleting.process(uuid, deleteAlgorithm);
    }

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

}
