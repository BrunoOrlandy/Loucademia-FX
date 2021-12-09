package br.com.loucademia.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("loucademia");

    public static EntityManager getEntityManager() {
	return emf.createEntityManager();
    }

//    create|update|validate|create-drop
//    create : - cria o schema, os dados anteriormente presentes (se houver) no schema são perdidos 
//    update: - atualiza o schema com os valores fornecidos. 
//    validate : - valida o schema. Não faz nenhuma alteração no banco de dados. 
//    create-drop: - cria o schema destruindo os dados anteriormente presentes (se houver).  Ele também descarta o schema do banco de dados quando o SessionFactory é fechado.

}
