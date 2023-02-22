package com.assignment.productService.ProductServiceTest;


import com.assignment.productService.model.Product;
import com.assignment.productService.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    void shouldCreateTutorial() throws Exception {
//        Product product = new Product(1, "Test Product", "Product Description");
//
//        mockMvc.perform(post("/api/products").contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(product)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//    }

    @Test
    void shouldReturnNotFoundTutorial() throws Exception {
        long id = 2L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        mockMvc.perform(get("/products", id))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
