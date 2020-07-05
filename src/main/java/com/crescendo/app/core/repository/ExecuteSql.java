package com.crescendo.app.core.repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExecuteSql implements Serializable {

	private static final long serialVersionUID = 8378140427317130584L;

	// @PersistenceContext
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");

	// private static EntityManager entityManager;

	private static final ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>() {

		@Override
		protected EntityManager initialValue() {
			return null;
		}
	};

	public static Integer executeCountSql(String queryString, Map<String, Object> queryArgs) {
		EntityManager em = getEntityManager();
		Query query = em.createNativeQuery(queryString);
		addParamsToQuery(query, queryArgs);
		Integer queryResult = (Integer) query.getSingleResult();
		return queryResult;
	}

	public static List<Object> executeNativeSqlString(String queryString, Map<String, Object> queryArgs, Class classT) {
		// ProgramThread.throwExceptionIfCurrentThreadIsInterrupted();
		System.out.println(" queryString " + queryString);
		EntityManager em = getEntityManager();
		Query query = em.createNativeQuery(queryString, classT);
		addParamsToQuery(query, queryArgs);
		@SuppressWarnings("unchecked")
		List<Object> queryResults = query.getResultList();
		return queryResults;
	}

	private static void addParamsToQuery(Query query, Map<String, Object> vars) {
        if ((vars != null) && !vars.isEmpty()) {
            Iterator<String> keys = vars.keySet().iterator();
            System.out.println("keys ::  " + keys.toString());
            while (keys.hasNext()) {
                String key = keys.next();
                Object param = vars.get(key);
                System.out.println("key  :: " + key + " param " + param);
				
				/*
				 * if (param instanceof DateType) { Date dateParam = ((DateType)
				 * param).getJDate(); if (dateParam == null) { // Hibernate unsure about type of
				 * null object, use date-specific method signature query.setParameter(key,
				 * dateParam, TemporalType.TIMESTAMP); } else { query.setParameter(key,
				 * dateParam); } } else if (param instanceof TimeType) { Date dateParam =
				 * ((TimeType) param).getJDate(); if (dateParam == null) { // Hibernate unsure
				 * about type of null object, use date-specific method signature
				 * query.setParameter(key, dateParam, TemporalType.TIME); } else {
				 * query.setParameter(key, dateParam); } } else if (param instanceof M204String)
				 * { query.setParameter(key, param.toString()); } else { query.setParameter(key,
				 * param); }
				 */
				 
                query.setParameter(key, param);
            }
        }
    }

	private static EntityManager getEntityManager() {
		/*
		 * if (entityManager == null) { entityManager =
		 * getEntityManagerFactory().createEntityManager(); } return entityManager;
		 */
		if (entityManager.get() == null) {
			entityManager.set(getEntityManagerFactory().createEntityManager());
		}
		return entityManager.get();
	}

	private static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			throw new RuntimeException("Entity Manager Factory must be initialized before retrieval.");
		}
		return entityManagerFactory;
	}

	/*
	 * public static void initEntityManagerFactory() { if (entityManagerFactory ==
	 * null) { entityManagerFactory = Persistence.createEntityManagerFactory("PU");
	 * } }
	 */

}
