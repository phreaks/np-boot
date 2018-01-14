package net.frischware.npboot.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.sql.DataSource;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import net.frischware.npboot.bean.C3P0DataSource;
import net.frischware.npboot.bean.Preference;
import oracle.jdbc.datasource.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;


/**
 * 
 * @author 
 *
 */
@Repository
public class PreferenceRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/*
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
	    hikariConfig.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/xe"); 
	    hikariConfig.setUsername("hr");
	    hikariConfig.setPassword("hr");

	    hikariConfig.setMaximumPoolSize(5);
	    //hikariConfig.setConnectionTestQuery("SELECT 1");
	    hikariConfig.setPoolName("springHikariCP");

	    //hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    //hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    //hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    //hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	}
	
	
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    */
	
	
    /*
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Bean
	public DataSource dataSource() throws SQLException {
		C3P0DataSource dataSource = C3P0DataSource.getInstance();
        //OracleDataSource dataSource = new OracleDataSource();
        return dataSource;
    }
	*/
    
	/**
	 * 
	 * @param pref
	 * @return
	 */
    public Preference create(final Preference pref, Long cnt) {
    		final String sql = "insert into notification_preferences(nopr_functional_id, nopr_customer_nr, nopr_partner_nr, nopr_account_nr,"
    				+ "nopr_channel, nopr_channel_name, nopr_channel_type, nopr_enabled, nopr_address, NOPR_CREATED, nopr_id) values(?,?,?,?,?,?,?,?,?,?,seq_nopr.nextval)";
    	 
        KeyHolder holder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            		LocalDate now = LocalDate.now();
            	
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, pref.getFunctionalId() + "-" + cnt );
                ps.setLong(2, pref.getCustomerNr());
                ps.setLong(3, pref.getPartnerNr());
                ps.setLong(4, pref.getAccountNr());
                ps.setString(5, pref.getChannel());
                ps.setString(6, pref.getChannelName());
                ps.setString(7, pref.getChannelType());
                ps.setBoolean(8, pref.getEnabled());
                ps.setString(9, pref.getAddress());
                ps.setDate(10, java.sql.Date.valueOf(now));
                
               // System.out.println("QUERY: " + ps.toString() );
                return ps;
            }
        }, holder);
 
        //long newId = holder.getKey().longValue();
        //pref.setId(newId);
        return pref;
    }
    
}
