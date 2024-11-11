package com.inditex.precios;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inditex.precios.model.Precios;
import com.inditex.precios.respository.PreciosRepository;

@SpringBootTest
@AutoConfigureMockMvc
class PreciosControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PreciosRepository preciosRepository;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

	// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
    @Test
    public void test1() throws Exception {
        LocalDateTime fecha = LocalDateTime.parse("2020-06-14-10.00.00", formatter);
        Precios precio = new Precios(null, 1, fecha.minusDays(1), fecha.plusDays(1), 1, new BigDecimal("35.50"), 35455, 0, "EUR");
        
        when(preciosRepository.obtenerFechaAplicacion(35455, 1, fecha)).thenReturn(Optional.of(precio));

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
        LocalDateTime fecha = LocalDateTime.parse("2020-06-14-16.00.00", formatter);
        Precios precio = new Precios(null, 1, fecha.minusDays(1), fecha.plusDays(1), 2, new BigDecimal("25.45"), 35455, 1, "EUR");
        
        when(preciosRepository.obtenerFechaAplicacion(35455, 1, fecha)).thenReturn(Optional.of(precio));

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
        LocalDateTime fecha = LocalDateTime.parse("2020-06-14-21.00.00", formatter);
        Precios precio = new Precios(null, 1, fecha.minusDays(1), fecha.plusDays(1), 1, new BigDecimal("35.50"), 35455, 0, "EUR");
        
        when(preciosRepository.obtenerFechaAplicacion(35455, 1, fecha)).thenReturn(Optional.of(precio));

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
        LocalDateTime fecha = LocalDateTime.parse("2020-06-15-10.00.00", formatter);
        Precios precio = new Precios(null, 1, fecha.minusDays(1), fecha.plusDays(1), 3, new BigDecimal("30.50"), 35455, 1, "EUR");
        
        when(preciosRepository.obtenerFechaAplicacion(35455, 1, fecha)).thenReturn(Optional.of(precio));

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
        LocalDateTime fecha = LocalDateTime.parse("2020-06-16-21.00.00", formatter);
        Precios precio = new Precios(null, 1, fecha.minusDays(1), fecha.plusDays(1), 4, new BigDecimal("38.95"), 35455, 1, "EUR");
        
        when(preciosRepository.obtenerFechaAplicacion(35455, 1, fecha)).thenReturn(Optional.of(precio));

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
