import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GestionDiasSemanaTest {
    private GestionDiasSemana gestionDias;

    @BeforeEach
    public void setUp() {
        gestionDias = new GestionDiasSemana();
        gestionDias.crearListaDias();
    }

    @Test
    public void testCrearListaDias() {
        List<String> dias = gestionDias.obtenerDiasSemana();
        assertEquals(7, dias.size());
        assertTrue(dias.contains("Lunes"));
        assertTrue(dias.contains("Domingo"));
    }

    @Test
    public void testObtenerDiasSemana() {
        List<String> dias = gestionDias.obtenerDiasSemana();
        assertEquals(7, dias.size());
        assertEquals("Lunes", dias.get(0));
    }

    @Test
    public void testObtenerLargoLista() {
        assertEquals(7, gestionDias.obtenerLargoLista());
    }

    @Test
    public void testEliminarDia() {
        gestionDias.eliminarDia("Lunes");
        assertEquals(6, gestionDias.obtenerLargoLista());
        assertFalse(gestionDias.existeDia("Lunes"));
    }

    @Test
    public void testObtenerDia() {
        assertEquals("Lunes", gestionDias.obtenerDia(0));
        assertNull(gestionDias.obtenerDia(10));
    }

    @Test
    public void testExisteDia() {
        assertTrue(gestionDias.existeDia("Martes"));
        assertFalse(gestionDias.existeDia("Feriado"));
    }

    @Test
    public void testOrdenarDiasAlfabeticamente() {
        gestionDias.ordenarDiasAlfabeticamente();
        assertEquals("Domingo", gestionDias.obtenerDia(0));
    }

    @Test
    public void testVaciarLista() {
        gestionDias.vaciarLista();
        assertEquals(0, gestionDias.obtenerLargoLista());
    }
}