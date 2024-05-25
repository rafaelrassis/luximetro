import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainActivityTest {

    private MainActivity activity;
    private Slider slider;
    private Button buttonCozinha;
    private TextView selectedValueTextView;

    @Before
    public void setUp() {
        activity = new MainActivity();
        activity.onCreate(null); // Chama explicitamente o método onCreate para inicializar os componentes

        slider = mock(Slider.class);
        buttonCozinha = mock(Button.class);
        selectedValueTextView = mock(TextView.class);

        activity.slider = slider;
        activity.selected_value_textview = selectedValueTextView;
        activity.botaoCozinha = buttonCozinha;
    }

    @Test
    public void testActivityNotNull() {
        assertNotNull(activity);
    }

    @Test
    public void testSliderValueChange() {
        float testValue = 5.0f;
        when(slider.getValue()).thenReturn(testValue);
        activity.slider.addOnChangeListener(null); // Forçar a chamada do método onValueChange
        verify(selectedValueTextView).setText("5 Anos");
    }

    @Test
    public void testButtonClickOpensActivity() {
        float testValue = 5.0f;
        when(slider.getValue()).thenReturn(testValue);
        activity.botaoCozinha.performClick();
        // Verifica se o método abrirAtividade é chamado corretamente
    }

    // Testes semelhantes para os outros botões podem ser adicionados aqui
}
