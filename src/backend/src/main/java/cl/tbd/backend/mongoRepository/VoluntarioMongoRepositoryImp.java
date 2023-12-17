package cl.tbd.backend.mongoRepository;

import cl.tbd.backend.models.Voluntario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoluntarioMongoRepositoryImp implements VoluntarioMongoRepository{

    @Autowired
    MongoDatabase database;

    @Override
    public List<Voluntario> findAll() {
        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        List <Voluntario> voluntarios = collection.find().into(new ArrayList<Voluntario>());

        return voluntarios;
    }

    @Override
    public Voluntario crearVoluntario(Voluntario newVoluntario){
        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        collection.insertOne(newVoluntario);
        return newVoluntario;
    }
}
