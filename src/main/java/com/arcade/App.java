import com.arcade.Task;
import com.arcade.TaskRepository;

void main(){
    try {
        TaskRepository.create(new Task("Going to gym!"));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
