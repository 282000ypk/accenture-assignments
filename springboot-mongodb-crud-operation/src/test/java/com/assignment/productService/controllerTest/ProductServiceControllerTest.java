//package com.assignment.productService.controllerTest;
//
//
//import com.assignment.productService.service.ProductService;
//import com.assignment.productService.model.Product;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import java.util.NoSuchElementException;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doThrow;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//public class ProductServiceControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    ProductService productservice;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    final String api = "/products";
//
//    @Test
//    public void whenCreateTopic_thenReturn301CreatedAndTopic() throws Exception {
//        Product product = new Product(1, "Product 1", "Product Description");
//        given(productservice.createProduct(any())).willReturn(product);
//
//        RequestBuilder request = post(api)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(product));
//        mockMvc.perform(request)
//                .andExpect(status().isCreated())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpectAll(
//                        jsonPath("$.productId").value("1"),
//                        jsonPath("$.name").value("Product 1")
//                );
//    }
//
//    @Test
//    void givenTopicDoesNotExists_whenDeleteTopic_thenReturn404NotFound() throws Exception {
//        doThrow(NoSuchElementException.class).when(productservice).deleteProduct(1L);
//        mockMvc.perform(productservice.deleteProduct(api + "/1")
//                .andExpect(status().isNotFound());
//    }
//}
