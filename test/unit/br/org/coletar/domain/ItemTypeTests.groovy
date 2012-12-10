package br.org.coletar.domain



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ItemType)
class ItemTypeTests {

    void testConstraintSuccess() {

        //prepare MOC for testing
        mockForConstraintsTests(ItemType)

        def itemType = new ItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 1,
                description: "Pode ser medido em litros"
        )

        assert itemType.validate()

    }

    void testConstraintsAttributesNameUnitOfMeasurementelUniqueSuccess() {

        //create existing ItemType
        def itemType = new ItemType(
                name: "Material reciclavel",
                unitOfMeasurement: "Kg",
                limitValue: 1,
                description: "Pode ser medido em Kilos"
        )


        mockForConstraintsTests(ItemType,[itemType])

        def newItemType = new ItemType(
                name: "Material reciclavel",
                unitOfMeasurement: "m3",
                limitValue: 1,
                description: "Pode ser medido em Metros cubicos"
        )

        assert newItemType.validate()

    }

    void testConstraintsAttributesNameUnitOfMeasurementelUniqueFail() {

        //create existing ItemType
        def itemType = new ItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 1,
                description: "Pode ser medido em litros"
        )


        mockForConstraintsTests(ItemType,[itemType])

        def newItemType = new ItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 2,
                description: "Pode ser medido em litros tambem"
        )

        assert !newItemType.validate()
        assert newItemType.errors.errorCount == 1
        assert "unique" == newItemType.errors["name"]

    }

    void testConstraintNullableFail() {

        //prepare MOC for testing
        mockForConstraintsTests(ItemType)

        def itemType = new ItemType()

        assert !itemType.validate()
        assert itemType.errors.errorCount == 4
        assert "nullable" == itemType.errors["name"]
        assert "nullable" == itemType.errors["unitOfMeasurement"]
        assert "nullable" == itemType.errors["limitValue"]
        assert "nullable" == itemType.errors["description"]

    }

    void testConstraintBlankFail() {

        //prepare MOC for testing
        mockForConstraintsTests(ItemType)

        def itemType = new ItemType(
                name: "    ",
                unitOfMeasurement: " ",
                limitValue: 1,
                description: " "
        )

        assert !itemType.validate()
        assert itemType.errors.errorCount == 3
        assert "blank" == itemType.errors["name"]
        assert "blank" == itemType.errors["unitOfMeasurement"]
        assert "blank" == itemType.errors["description"]

    }


    void testConstraintLimitValue(){

        //prepare MOC for testing
        mockForConstraintsTests(ItemType)

        def itemType = new ItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 0,
                description: "Pode ser medido em litros"
        )

        assert !itemType.validate()
        assert itemType.errors.errorCount == 1
        assert "min" == itemType.errors["limitValue"]

        itemType = new ItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: -1,
                description: "Pode ser medido em litros"
        )

        assert !itemType.validate()
        assert itemType.errors.errorCount == 1
        assert "min" == itemType.errors["limitValue"]

    }




}
