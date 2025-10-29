import com.arcade.JdbcConnection;

import java.sql.SQLException;

void main(){
    try {
        JdbcConnection.operate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
