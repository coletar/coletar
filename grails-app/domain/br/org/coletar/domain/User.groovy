package br.org.coletar.domain

import grails.validation.Validateable

/**
 * Created with IntelliJ IDEA.
 * User: sauloandrade
 * Date: 12/2/12
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Validateable
class User {

    String name
    String email
    String password

    static constraints = {
        name  blank: false
        email email: true, blank: false, unique: true
        password size: 5..15, blank: false

    }
}
