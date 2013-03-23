package br.org.coletar.domain

import grails.validation.Validateable

@Validateable
class ItemTypeLimitsForCollectStation {

    CollectStation collectStation
    CollectItemType collectItemType
    Integer minLimit
    Integer maxLimit

    static constraints = {
        minLimit min: 1
        maxLimit min: 1
        collectStation unique: 'collectItemType'
    }
}
