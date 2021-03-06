package pl.sda.coursesproject.domain.block;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {

    public Block findBlockByName (String name);
}
