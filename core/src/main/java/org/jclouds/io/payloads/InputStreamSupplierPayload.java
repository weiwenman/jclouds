/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.io.payloads;

import static org.jclouds.util.Closeables2.closeQuietly;

import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;

/**
 * @deprecated see ByteSourcePayload
 */
@Deprecated
public class InputStreamSupplierPayload extends BasePayload<InputSupplier<? extends InputStream>> {
   private final Closer closer = Closer.create();

   public InputStreamSupplierPayload(InputSupplier<? extends InputStream> content) {
      super(content);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public InputStream openStream() throws IOException {
      return closer.register(content.getInput());
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean isRepeatable() {
      return true;
   }

   /**
    * if we created the stream, then it is already consumed on close.
    */
   @Override
   public void release() {
      closeQuietly(closer);
   }
}
