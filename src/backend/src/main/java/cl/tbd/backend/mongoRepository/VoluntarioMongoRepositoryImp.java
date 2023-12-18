package cl.tbd.backend.mongoRepository;

import cl.tbd.backend.models.Voluntario;
import cl.tbd.backend.repositories.DatabaseContext;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class VoluntarioMongoRepositoryImp implements VoluntarioMongoRepository {


    @Autowired
    private MongoDatabase database;
    private final MongoTemplate mongoTemplate;

    public VoluntarioMongoRepositoryImp(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public long getTotalHabilidadesCount() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("habilidades"),
                Aggregation.group().count().as("totalHabilidades"),
                Aggregation.project().andExclude("_id").and("totalHabilidades").as("totalHabilidades")
        );

        AggregationResults<TotalHabilidadesCountResult> result =
                mongoTemplate.aggregate(aggregation, "voluntarios", TotalHabilidadesCountResult.class);

        List<TotalHabilidadesCountResult> mappedResults = result.getMappedResults();
        return mappedResults.isEmpty() ? 0 : mappedResults.get(0).getTotalHabilidades();
    }

    public List<Voluntario> findAll(){
        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        List<Voluntario> voluntarios = collection.find().into(new ArrayList<>());
        return voluntarios;
    }

    public Voluntario crearVoluntario(Voluntario newVoluntario){

        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        collection.insertOne(newVoluntario);
        return newVoluntario;
    }

    public void eliminar(String nombre){

        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        collection.deleteOne(new Document("nombreVoluntario", nombre));
    }

    public Voluntario actualizar(Voluntario newVoluntario){

        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        Bson filtro = Filters.eq("nombreVoluntario", newVoluntario.getNombreVoluntario());

        Bson actualizacion = new Document("$set", newVoluntario);

        UpdateResult resultado = collection.updateOne(filtro, actualizacion);

        if (resultado.getModifiedCount() > 0) {
            return newVoluntario;
        } else {
            return null;
        }
    }
}
