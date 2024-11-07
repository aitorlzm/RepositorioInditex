package com.inditex.precios;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class PreciosControllerTest  {
	
	@Autowired
	private MockMvc mockMvc;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
	
    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
	@Test
	public void test1 () throws Exception {
		mockMvc.perform(get("/api/precios/consultar")
				.param("fecha", "2020-06-14-10.00.00")
                .param("productoId", "35455")
                .param("marcaId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
	}
	
    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
	@Test
    public void test2() throws Exception {
        mockMvc.perform(get("/api/precios/consultar")
                .param("fecha", "2020-06-14-16.00.00")
                .param("productoId", "35455")
                .param("marcaId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
    @Test
    public void test3() throws Exception {
        mockMvc.perform(get("/api/precios/consultar")
                .param("fecha", "2020-06-14-21.00.00")
                .param("productoId", "35455")
                .param("marcaId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
    @Test
    public void test4() throws Exception {
        mockMvc.perform(get("/api/precios/consultar")
                .param("fecha", "2020-06-15-10.00.00")
                .param("productoId", "35455")
                .param("marcaId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
    @Test
    public void test5() throws Exception {
        mockMvc.perform(get("/api/precios/consultar")
                .param("fecha", "2020-06-16-21.00.00")
                .param("productoId", "35455")
                .param("marcaId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(38.95));
    }
	

}
