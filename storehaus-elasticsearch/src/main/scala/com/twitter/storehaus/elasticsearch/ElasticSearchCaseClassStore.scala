/*
 * Copyright 2014 Twitter inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.twitter.storehaus.elasticsearch

import org.elasticsearch.client.Client
import Injections._
import org.elasticsearch.action.search.SearchRequest

/**
 * @author Mansur Ashraf
 * @since 1/13/14
 */
object ElasticSearchCaseClassStore {
  def apply[V <: AnyRef : Manifest](index: String,
                                     tipe: String,
                                     client: Client) = QueryableConvertedStore.convert[String,String,String,V,SearchRequest](new ElasticSearchStringStore(index, tipe, client))(_.toString)
}
