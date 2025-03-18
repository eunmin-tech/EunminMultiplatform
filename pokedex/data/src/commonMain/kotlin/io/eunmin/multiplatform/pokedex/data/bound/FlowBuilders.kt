package io.eunmin.multiplatform.pokedex.data.bound

fun <DataType, DomainType> flowDataResource(
    dataAction: suspend () -> DataType,
    mapper: (DataType) -> DomainType,
) =
    FlowBoundResource<DomainType, DataType>(dataAction, mapper)

fun <DataType> flowDataResource(
    dataAction: suspend () -> DataType,
) =
    FlowBoundResource<Unit, DataType>(dataAction) { it }
