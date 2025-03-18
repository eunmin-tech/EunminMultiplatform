package io.eunmin.multiplatform.pokedex.data.bound

import io.eunmin.multiplatform.data_resource.DataResource
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector

class FlowBoundResource<DomainType, DataType>(
    dataAction: suspend () -> DataType,
    mapper: (DataType) -> DomainType,
) :
    FlowBaseBoundResource<DomainType, DataType>(dataAction, mapper) {

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<DataResource<DomainType>>) {
        fetchFromSource(collector)
    }
}