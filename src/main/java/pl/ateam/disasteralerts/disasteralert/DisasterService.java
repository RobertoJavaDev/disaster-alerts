package pl.ateam.disasteralerts.disasteralert;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ateam.disasteralerts.disasteralert.dto.DisasterAddDTO;
import pl.ateam.disasteralerts.disasteralert.dto.DisasterDTO;

@Service
@RequiredArgsConstructor
class DisasterService implements DisasterServiceAPI{

    private final DisasterRepository repository;
    private final DisasterMapper mapper;

    @Transactional
    public DisasterDTO addDisaster(DisasterAddDTO disasterAddDTO){

        Disaster disaster = mapper.disasterAddDtoToDisaster(disasterAddDTO);

        DisasterDTO disasterDTO = mapper.disasterToDto(
                repository.save(disaster));

        return disasterDTO;
    }
}
