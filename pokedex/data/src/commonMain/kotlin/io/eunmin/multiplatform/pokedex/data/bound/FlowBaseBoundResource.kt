package io.eunmin.multiplatform.pokedex.data.bound

import io.eunmin.multiplatform.data_resource.DataResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

abstract class FlowBaseBoundResource<DomainType, DataType>(
    private val dataAction: suspend () -> DataType,
    private val mapper: (DataType) -> DomainType,
) :
    Flow<DataResource<DomainType>> {

    protected open suspend fun fetchFromSource(
        collector: FlowCollector<DataResource<DomainType>>,
        successAction: (suspend (DataType) -> Unit)? = null,
    ) {
        try {
            val data = dataAction()
            val domainModel: DomainType = mapper(data)
            collector.emit(DataResource.success(domainModel))
            successAction?.invoke(data)
        } catch (exception: Exception) {
            collector.emit(DataResource.error(exception))
        }
    }
}
