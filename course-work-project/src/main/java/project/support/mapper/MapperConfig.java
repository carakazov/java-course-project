package project.support.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public class MapperConfig {
}
