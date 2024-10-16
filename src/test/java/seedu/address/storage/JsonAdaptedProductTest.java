package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.product.Product;
import seedu.address.model.product.ProductName;

public class JsonAdaptedProductTest {

    private static final String VALID_NAME = "Apple";
    private static final String VALID_SUPPLIER_NAME = "SupplierA";
    private static final int VALID_STOCK_LEVEL = 50;
    private static final int VALID_MIN_STOCK_LEVEL = 10;
    private static final int VALID_MAX_STOCK_LEVEL = 100;

    private static final String INVALID_NAME = "R@chel";

    @Test
    public void toModelType_validProductDetails_returnsProduct() throws Exception {
        JsonAdaptedProduct product = new JsonAdaptedProduct(VALID_NAME, VALID_SUPPLIER_NAME, VALID_STOCK_LEVEL,
                VALID_MIN_STOCK_LEVEL, VALID_MAX_STOCK_LEVEL);
        Product expectedProduct = new Product(new ProductName(VALID_NAME));
        expectedProduct.setSupplierName(new seedu.address.model.supplier.Name(VALID_SUPPLIER_NAME));
        expectedProduct.setStockLevel(VALID_STOCK_LEVEL);
        expectedProduct.setMinStockLevel(VALID_MIN_STOCK_LEVEL);
        expectedProduct.setMaxStockLevel(VALID_MAX_STOCK_LEVEL);
        assertEquals(expectedProduct, product.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedProduct product = new JsonAdaptedProduct(INVALID_NAME, VALID_SUPPLIER_NAME, VALID_STOCK_LEVEL,
                VALID_MIN_STOCK_LEVEL, VALID_MAX_STOCK_LEVEL);
        assertThrows(IllegalValueException.class, product::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedProduct product = new JsonAdaptedProduct(null, VALID_SUPPLIER_NAME, VALID_STOCK_LEVEL,
                VALID_MIN_STOCK_LEVEL, VALID_MAX_STOCK_LEVEL);
        assertThrows(IllegalValueException.class, product::toModelType);
    }
}
