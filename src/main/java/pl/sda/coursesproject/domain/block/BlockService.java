package pl.sda.coursesproject.domain.block;

import org.springframework.stereotype.Service;

@Service
public class BlockService {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }
}
