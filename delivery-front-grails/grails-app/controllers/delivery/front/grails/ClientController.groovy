package delivery.front.grails

class ClientController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def scaffold = Client // Note the capital

    def index(){

    }

    def show(Client clientInstance) {
        respond clientInstance
    }

    def create() {
        respond new Client(params)
    }

    def edit(Client clientInstance) {

    }

    def save(Client clientInstance) {

    }

    def update(Client clientInstance) {

    }

    def delete(Client clientInstance) {

    }
}
