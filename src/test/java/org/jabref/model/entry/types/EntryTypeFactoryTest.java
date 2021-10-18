package org.jabref.model.entry.types;
import org.jabref.model.entry.BibEntryType;
import org.jabref.model.entry.field.BibField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.jabref.model.entry.field.FieldPriority;
import org.jabref.model.entry.field.StandardField;
import static org.junit.jupiter.api.Assertions.assertEquals;




class EntryTypeFactoryTest {
    private static final EntryType CUSTOM_TYPE = new UnknownEntryType("customType");
    //Class and entry for the class
    private EntryTypeFactory entryType;
    private BibEntryType entry;


    @BeforeEach
    public void setup(){
        entryType = new EntryTypeFactory();
        entry = new BibEntryType(CUSTOM_TYPE, List.of(new BibField(StandardField.AUTHOR, FieldPriority.IMPORTANT)),
                Collections.emptySet());
    }

    @Test
    public void testeDoisNulls() {
        boolean RetornoFeito = entryType.isEqualNameAndFieldBased(null, null);
        assertEquals(true, RetornoFeito);
    }

    @Test
    public void TesteUmNull() {
        boolean RetornoFeito = entryType.isEqualNameAndFieldBased(null, entry);
        assertEquals(false, RetornoFeito);
    }

    @Test
    public void testeUmNullInv() {
        boolean RetornoFeito = entryType.isEqualNameAndFieldBased(entry, null);
        assertEquals(false, RetornoFeito);
    }

    @Test
    public void testeUmNullTrue() {
        boolean RetornoFeito = entryType.isEqualNameAndFieldBased(entry, entry);
        assertEquals(Objects.equals(entry.getType(), entry.getType())
                && Objects.equals(entry.getRequiredFields(), entry.getRequiredFields())
                && Objects.equals(entry.getOptionalFields(), entry.getOptionalFields())
                && Objects.equals(entry.getSecondaryOptionalFields(), entry.getSecondaryOptionalFields()), RetornoFeito);
    }



}
