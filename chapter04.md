# Spring database development

## Spring JDBC
> JdbcAccessor <- JdbcTemplate -> JdbcOperations
> JdbcOperations接口定义了增删改查等操作
> JbdcAccessor为子类提供了一些公共属性：
>   - dataSource
>   - SQLExceptionTranslator

## Spring JDBC Setting
> applicationContext配置
> ![chapter04_JDBC_Setting](/img/chapter04_JDBC_Setting.png)

## CRUD
```Java
public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user (username, password) value(?,?)";
        Object[] obj = new Object[]{
                user.getUsername(),
                user.getPassword()
        };
        int num = this.jdbcTemplate.update(sql,obj);
        return num;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set username=?,password=? where id=?";
        Object[] params = new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getId()
        };
        int num = this.jdbcTemplate.update(sql,params);
        return num;
    }

    @Override
    public int deletUser(int id) {
        String sql = "delete from user where id=?";
        int num = this.jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }
}
```