package PropertyEditors;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class CustomePropertyEditor implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(ComplexNumber.class,new ComplexNumberPropertyEditors());
    }
}
