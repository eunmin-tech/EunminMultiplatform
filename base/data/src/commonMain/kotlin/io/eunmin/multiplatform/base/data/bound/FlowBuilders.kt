package io.eunmin.multiplatform.base.data.bound

fun <DataType, DomainType> flowDataResource(
    dataAction: suspend () -> DataType,
    mapper: (DataType) -> DomainType,
) =
    FlowBoundResource(dataAction, mapper)

fun <DataType, DomainType> flowDataResource(
    dataAction: suspend () -> DataType,
    localSourceAction: suspend () -> DataType?,
    saveCache: suspend (DataType) -> Unit,
    mapper: (DataType) -> DomainType,
) =
    FlowPersistableRemoteBoundResource(
        dataAction, mapper, localSourceAction, saveCache
    )
