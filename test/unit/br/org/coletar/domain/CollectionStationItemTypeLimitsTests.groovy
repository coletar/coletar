package br.org.coletar.domain



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CollectionStationItemTypeLimits)
@Mock([CollectionStation, CollectItemType])
class CollectionStationItemTypeLimitsTests {


    void testConstraintCollectionStationCollectItemTypeUniqueFail() {

        def existentCollectionStation = new CollectionStation()
        def existentCollectItemType = new CollectItemType()

        //create existent CollectionStationItemTypeLimits
        def existentCollectionStationItemTypeLimits =
            new CollectionStationItemTypeLimits(collectItemType: existentCollectItemType,
                                                collectionStation: existentCollectionStation,
                                                minLimit: 1,
                                                maxLimit: 1)

        mockForConstraintsTests(CollectionStationItemTypeLimits,[existentCollectionStationItemTypeLimits])

        def newCollectionStationItemTypeLimits =
            new CollectionStationItemTypeLimits(collectItemType: existentCollectItemType,
                    collectionStation: existentCollectionStation,
                    minLimit: 5,
                    maxLimit: 7)

        assert !newCollectionStationItemTypeLimits.validate()
        assert newCollectionStationItemTypeLimits.errors.errorCount == 1
        assert "unique" == newCollectionStationItemTypeLimits.errors["collectionStation"]
    }

    void testConstraintCollectionStationCollectItemTypeUniqueSuccess() {

        def existentCollectionStation = new CollectionStation()
        def existentCollectItemType = new CollectItemType()

        //create existent CollectionStationItemTypeLimits
        def existentCollectionStationItemTypeLimits =
            new CollectionStationItemTypeLimits(collectItemType: existentCollectItemType,
                    collectionStation: existentCollectionStation,
                    minLimit: 1,
                    maxLimit: 1)

        mockForConstraintsTests(CollectionStationItemTypeLimits,[existentCollectionStationItemTypeLimits])

        def newCollectionStationItemTypeLimits =
            new CollectionStationItemTypeLimits(collectItemType: new CollectItemType(),
                    collectionStation: new CollectionStation(),
                    minLimit: 5,
                    maxLimit: 7)

        assert newCollectionStationItemTypeLimits.validate()
    }
}
